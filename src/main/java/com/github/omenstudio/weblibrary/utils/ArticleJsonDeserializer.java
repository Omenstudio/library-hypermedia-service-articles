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
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ArticleJsonDeserializer extends JsonDeserializer<Article> {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    MagazineRepository magazineRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Article deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Article book = new Article();

        JsonNode node = jp.getCodec().readTree(jp);

        book.setTitle(getText(node, "title"));
        book.setAnnotation(getText(node, "annotation"));
        book.setPageStart(getText(node, "pageStart"));
        book.setPageEnd(getText(node, "pageEnd"));
        book.setWordCount(getInt(node, "wordCount"));

        Long authorId = getHypermediaIdHack(node, "authors");
        if (authorId != null)
            book.addAuthor(authorRepository.findOne(authorId));

        Long magazineId = getHypermediaIdHack(node, "magazine");
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

    private static Long getHypermediaIdHack(JsonNode parent, String title) {
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
