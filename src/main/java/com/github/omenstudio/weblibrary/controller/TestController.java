package com.github.omenstudio.weblibrary.controller;

import com.github.omenstudio.weblibrary.entity.Article;
import com.github.omenstudio.weblibrary.entity.Author;
import com.github.omenstudio.weblibrary.entity.Magazine;
import com.github.omenstudio.weblibrary.repository.ArticleRepository;
import com.github.omenstudio.weblibrary.repository.AuthorRepository;
import com.github.omenstudio.weblibrary.repository.MagazineRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class TestController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    MagazineRepository magazineRepository;

    @Autowired
    AuthorRepository authorRepository;


    @GetMapping("/iamalive")
    public boolean iAmAlive() {
        return true;
    }


    @GetMapping("/resetdb")
    @SneakyThrows
    public void resetDb() {
        // Clear the database
        articleRepository.deleteAll();
        magazineRepository.deleteAll();
        authorRepository.deleteAll();

        // Randomize
        Random r = new Random();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        // Authors
        List<Author> authors = Arrays.asList(
                new Author("Tarabanko Kirill", format.parse("1994-1-13")),
                new Author("Agarkov Nikolay", format.parse("1991-2-27")),
                new Author("Lipuntsov Ilya", format.parse("1998-3-2")),
                new Author("Erman Nikita", format.parse("2000-4-6")),
                new Author("Svetlana Makarova", format.parse("2003-5-28")),
                new Author("Vitaly Kostarev", format.parse("1997-6-30")),
                new Author("Pupkin Vasily", format.parse("1995-7-29")),
                new Author("Makarutin Mihail", format.parse("1992-8-16")),
                new Author("Druzhinin Vova",  format.parse("1986-9-19"))
        );

        // Magazines
        Magazine[] magazines = new Magazine[] {
                new Magazine("Modern science", "Magazine about modern science, innovations and inventions", 2, 1024, "978-5-9614-6244-9"),
                new Magazine("Blockchain magazine", "Magazine about blockchain, bitcoin, ethereum, BTC cash, etc.", 6, 542, "978-5-699-88634-0"),
                new Magazine("Info business", "Magazine about: \"How to earn a lot of money without working!\"", 13, 123, "978-5-699-87785-0"),
                new Magazine("Space anomalies", "Space, black holes, stars - are very interesting themes. It is magazine about.", 25, 295, "978-5-9614-6406-1"),
                new Magazine("Shit happens magazine #1", "Shit happens. Just shit. Just happens.", 1, 269, "978-5-91671-563-7"),
        };

        // Articles
        Article[] articles = new Article[] {
                new Article("Play and learning in early childhood education in Sweden",
                       "explore how “learning through play” and a “play-based curriculum” are understood and transformed " +
                                "into practice, we may find differences both within and between countries (Karlsson Lohmander & " +
                                "Pramling Samuelsson, 2014a, 2014b; Pramling Samuelsson & Fleer, 2009). In this article we discuss " +
                                "the relationship between the concepts of play and learning and describe",
                        "12", "14", 200),
                new Article("Software tools for organization and support of distance learning game system «3Ducation»",
                        "structural scheme of distance learning system «3Ducation», as well as the purpose " +
                                "and capabilities of all its constituent software components, describes its main features. " +
                                "The system «3Ducation» is built on two pillars: the game approache and technologies of " +
                                "virtual worlds. Virtual reality technology allows to move the learning process into the three-dimensional",
                        "21", "30", 500),
                new Article("Remediation of learning disable children following L. S. Vygotskys approach",
                        "Peculiarities of individual, group and dyadic methods of remediation are described " +
                                "with regard to its potential for mediating child's activity. Keywords: remediating " +
                                "education, learning disabilities, cultural-historical psychology, L.S. Vygotsky, mediation," +
                                " play therapy. The works of L.S. Vygotsky started 1917 in his native town Gomel with assessing an",
                        "35", "44", 921),
                new Article("Combined Use of Command-Proportional Control of External Robotic Devices Based on Electromyography Signals",
                        "one, and found the optimal parameters for command classification accuracy, as well " +
                                "as speed and accuracy of proportional control. Key words: electromyography; EMG; machine" +
                                " learning; proportional control; robot; exoskeleton. The use of human brain and muscle" +
                                " signals for adaptive control of external robotic devices is a critical interdisciplinary task ",
                        "40", "55", 462),
                new Article("Museums as spaces and times for learning and social participation",
                        "collective memory (Wertsch, 2004). Social interactions and working in participants' " +
                                "zone of proximal development (Vygotsky, 1934/1962) play an important role in non-formal " +
                                "learning opportunities that take place at museums. The National Museum of Natural History " +
                                "and Science (Lisbon University) offers weekly holiday programmes for children and teenagers \n" ,
                        "56", "60", 795),
                new Article("Students’ development in the learning process",
                        "The study endeavors to identify the components of certain abilities consciously " +
                                "acquired by a student in the process of learning. The study was arranged in two directions:" +
                                " the teaching of students to master intellectual operations and use them in their work " +
                                "with training materials, and psychological testing of control and experimental student" +
                                " groups before and after training tests\n",
                        "62", "67", 153),
                new Article("The Role of Companies in Human Capital Accumulation: A Cross-Country Analysis",
                        "Center (Levada Center) Address: 17 Nikolskaya str., 109012 Moscow, Russian Federation " +
                                "E-mail: nut@levada.ru Keywords human capital; top-managers of companies; lifelong learning;" +
                                " formal training of adult population; higher education; inequality in education and training; " +
                                "professional skills; innovation activity of companies DOI: 10.17323/1995-459X \n" ,
                        "78", "96", 197),
                new Article("Creating test data for market surveillance systems with Embedded machine learning algorithms",
                        "latest financial crisis. Such systems are designed to detect market abuse behavior " +
                                "and prevent it. The latest approach to the development of such systems is to use machine" +
                                " learning methods that largely improve the accuracy of market abuse predictions. These" +
                                " intelligent market surveillance systems are based on data mining methods, which build their own \n" ,
                        "85", "98", 984),
                new Article("Low-molecular-weight NGF mimetic corrects the cognitive deficit and depression-like behavior in experimental diabetes",
                        "Research Institute of Pharmacology. The study revealed the ability of GK-2 to ameliorate" +
                                " hyperglycemia induced by streptozotocine (STZ 100 mg/kg i.p.) in C57Bl/6 mice, to" +
                                " restore learning ability in the Morris Water Maze test, and to overcome depression " +
                                "after both intraperitoneal (0.5 mg/kg) and peroral (5 mg/kg) long-term administration." +
                                " The presence of the \n",
                        "92", "106", 465),
                new Article("Play and playfulness in early childhood education and care",
                        "of e-learning in higher education institutions. Results: the main approaches, " +
                                "applied to the formulation of educational practices in the electronic environment, " +
                                "were analyzed. The most topical national approaches include system, activity, " +
                                "polysubject (dialogical), context, and dialogical ones. Among international approaches " +
                                "self-directed learning, educational \n",
                        "102", "148", 130),
                new Article("Problem solution as a guided activity with Mexican schoolchildren",
                        "development of the ability to analyze problems. Keywords: problem solution, " +
                                "learning of mathematics, teaching methods, school age, orientation in mathematics," +
                                " conceptual learning Introduction In Mexico, the teaching of mathematics in primary " +
                                "school faces severe difficulties. The learning of school pupils is extremely poor." +
                                " The results of national tests show \n",
                        "162", "187", 610),
                new Article("Development of children’s early understanding of numeric structure",
                        "numbers, facilitating the development of base-10 representations. In the present " +
                                "study, we tested this view against an alternative view, positing that variability " +
                                "in children's learning of numeric structure may reflect differences in their experiences" +
                                " with numbers. The study examined kindergartners and first-graders from four countries: " +
                                "Taiwan, South Korea \n",
                        "123", "174", 444),
                new Article("Psychological prerequisites and effects of using multimedia content in the mass media",
                        "Multimedia technologies have increased during the last decade. They have expanded " +
                                "their reach tremendously and have entered our everyday lives. Currently, such spheres " +
                                "as tourism, learning, computing and business are widely using multimedia in various projects. " +
                                "However, the entertainment sphere is now the main user of multimedia. Gaming and cinema industries \n",
                        "321", "364", 498),
                new Article("Patent Landscape for Nanotechnology",
                        "determination of the thematic scope for newly developed educational programs; " +
                                "the development of the joint intellectual and material recourse base for the needs " +
                                "of the teaching and learning activities; the selection of the potentially interested " +
                                "company-partners, which can provide the relevant structure and guarantee the quality " +
                                "of the program of manufacturing \n",
                        "666", "667", 153),
        };

        // Assign random authors and random magazine to each article
        for (Article article : articles) {
            article.setMagazine(magazines[r.nextInt(magazines.length)]);

            Collections.shuffle(authors);

            int authorCount = 1 + r.nextInt(authors.size() / 3);
            authors.subList(0, authorCount).forEach(article::addAuthor);
        }

        // Save all
        authorRepository.save(authors);
        magazineRepository.save(Arrays.asList(magazines));
        articleRepository.save(Arrays.asList(articles));
    }

}
