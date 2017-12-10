package com.github.omenstudio.weblibrary.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.omenstudio.weblibrary.entity.Article;
import com.github.omenstudio.weblibrary.repository.ArticleRepository;
import com.github.omenstudio.weblibrary.repository.AuthorRepository;
import com.github.omenstudio.weblibrary.repository.MagazineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArticleJsonDeserializer extends JsonDeserializer<Article> {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    MagazineRepository magazineRepository;

    @Autowired
    AuthorRepository authorRepository;

    private static Logger logger = LoggerFactory.getLogger(ArticleJsonDeserializer.class);

    @Override
    public Article deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Article book = new Article();

        JsonNode node = jp.getCodec().readTree(jp);

        book.setTitle(getText(node, "title"));
        book.setAnnotation(getText(node, "annotation"));
        book.setPageStart(getText(node, "pageStart"));
        book.setPageEnd(getText(node, "pageEnd"));
        book.setWordCount(getInt(node, "wordCount"));

        getHypermediaIdList(node, "authors").forEach(authorId -> {
            try {
                book.addAuthor(authorRepository.findOne(authorId));
            }
            catch (Exception e) {
                logger.error(e.toString());
            }
        });

        Long magazineId = getHypermediaId(node, "magazine");
        if (magazineId != null)
            book.setMagazine(magazineRepository.findOne(magazineId));

        return book;
    }

    private static String getText(JsonNode parent, String title) {
        if (parent.has(title) && !parent.get(title).isNull()) {
            String res = parent.get(title).asText();
            if (res.length() != 0)
                return res;
        }
        return null;
    }

    private static Long getLong(JsonNode parent, String title) {
        if (parent.has(title) && !parent.get(title).isNull()) {
            return parent.get(title).asLong();
        }
        return null;
    }

    private static Integer getInt(JsonNode parent, String title) {
        if (parent.has(title) && !parent.get(title).isNull()) {
            return parent.get(title).asInt();
        }
        return null;
    }

    private static List<Long> getHypermediaIdList(JsonNode parent, String title) {
        if (parent.has(title) && !parent.get(title).isNull()) {
            return Arrays.stream(parent.get(title).asText().split(","))
                    .map(String::trim)
                    .map(Long::parseLong)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    private static Long getHypermediaId(JsonNode parent, String title) {
        if (parent.has(title) && !parent.get(title).isNull()) {
            String linkStr = parent.get(title).asText().trim();

            if (!linkStr.isEmpty()) {
                try {
                    return Long.parseLong(linkStr);
                } catch (NumberFormatException e) {/* do nothing */}

                String[] tokens = linkStr.split("/");
                if (tokens.length > 0) {
                    return Long.parseLong(tokens[tokens.length - 1]);
                }
            }
        }

        return null;
    }


}
