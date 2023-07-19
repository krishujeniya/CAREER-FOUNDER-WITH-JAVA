
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class project {
    public static void main(String[] args) {
        List<String> topics = new ArrayList<>();
        topics.add(
                "Digital Marketeing \nVideo Links:\n1. https://youtube.com/playlist?list=PLjVLYmrlmjGfdvrkrYB832s7UjVM4nKQ6 \n2. https://youtube.com/playlist?list=PLEiEAq2VkUULa5aOQmO_al2VVmhC-eqeI \n3. https://youtube.com/playlist?list=PLXwTOG3-tRwiJmAyVJ47SVvv-dUIy2S0I ");
        topics.add(
                "Machine Learning \nVideo Links:\n1. https://youtube.com/playlist?list=PLu0W_9lII9ai6fAMHp-acBmJONT7Y4BSG \n2. https://youtube.com/playlist?list=PLZoTAELRMXVPBTrWtJkn3wWQxZkmTXGwe  \n3.  https://youtube.com/playlist?list=PLYwpaL_SFmcBhOEPwf5cFwqo5B-cP9G4P  ");
        topics.add(
                "Full-stack Web Development \nVideo Links:\n1. https://youtube.com/playlist?list=PLqleLpAMfxGCEjPpf0lDMQHPO96sYN4ee \n2. https://youtube.com/playlist?list=PLfqMhTWNBTe3H6c9OGXb5_6wcc1Mca52n \n3. https://youtube.com/playlist?list=PLu0W_9lII9agiCUZYRsvtGTXdxkzPyItg ");
        topics.add(
                "Android Development \nVideo Links:\n1. https://youtube.com/playlist?list=PLu0W_9lII9aiL0kysYlfSOUgY5rNlOhUd  \n2. https://youtube.com/playlist?list=PLjVLYmrlmjGdDps6HAwOOVoAtBPAgIOXL \n3. https://youtube.com/playlist?list=PLUcsbZa0qzu3Mri2tL1FzZy-5SX75UJfb ");
        topics.add(
                "Data Science \nVideo Links:\n1. https://youtube.com/playlist?list=PLWKjhJtqVAblQe2CCWqV4Zy3LY01Z8aF1  \n2. https://youtube.com/playlist?list=PLeo1K3hjS3us_ELKYSj_Fth2tIEkdKXvV \n3. https://youtube.com/playlist?list=PLEiEAq2VkUUIEQ7ENKU5Gv0HpRDtOphC6 ");
        topics.add(
                "Game Development\nVideo Links:\n1. https://youtube.com/playlist?list=PLS1QulWo1RIa33eZnzAAkmZPiG2JsdVov \n2. https://youtube.com/playlist?list=PLBh8phtAyHPUY9fqgs1w6aHJALJ3_fMSc \n3. https://youtube.com/playlist?list=PLI5KGtDrj4HVInyXdx5N2oYUAb9U7rJ4L ");

        List<String> questions = getQuestions();
        List<String> answers = getAnswers();

        List<String> selectedQuestions = new ArrayList<>();
        List<String> selectedAnswers = new ArrayList<>();

        Random random = new Random();

        // Select 4 random questions for each topic
        for (String topic : topics) {
            int topicIndex = topicIndex(topic);
            for (int i = 0; i < 4; i++) {
                int questionIndex = random.nextInt(10) + topicIndex;
                selectedQuestions.add(questions.get(questionIndex));
                selectedAnswers.add(answers.get(questionIndex));
            }
        }

        Scanner scanner = new Scanner(System.in);
        List<String> userAnswers = new ArrayList<>();

        System.out.println("Welcome to the MCQ Test!");
        System.out.println("There are a total of 24 questions from different topics.");
        System.out.println("Please select the correct option (a, b, or c) for each question.\n");
        System.out.print("Please Enter your name: ");
        String userName = scanner.nextLine();

        // Ask questions and get user answers
        for (int i = 0; i < selectedQuestions.size(); i++) {
            String question = selectedQuestions.get(i);
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            userAnswers.add(userAnswer);
            System.out.println();
        }

        scanner.close();

        // Check answers and calculate score
        int score = 0;
        for (int i = 0; i < selectedQuestions.size(); i++) {
            String userAnswer = userAnswers.get(i);
            String correctAnswer = selectedAnswers.get(i);

            if (userAnswer.equals(correctAnswer)) {
                score++;
            }
        }
        // Determine the topic with the highest score
        int maxScore = 0;
        String topicName = "";
        for (int i = 0; i < topics.size(); i++) {
            int topicScore = 0;
            for (int j = i * 4; j < (i + 1) * 4; j++) {
                if (userAnswers.get(j).equals(selectedAnswers.get(j))) {
                    topicScore++;
                }
            }
            if (topicScore > maxScore) {
                maxScore = topicScore;
                topicName = topics.get(i);
            }
        }

        try (FileWriter writer = new FileWriter("data.txt",true)) {
            writer.write("\n\nName: " + userName + "\n");
            writer.write("Score: " + score + " out of 24\n");
            writer.write("Topic with the highest score: " + topicName);
        } catch (IOException e) {
            e.printStackTrace();
        }
            System.out.println("Thank you, " + userName);
            System.out.println("Test completed!");
            System.out.println("Your score: " + score + " out of 24");
            System.out.println("Topic with the highest score: " + topicName);
    }

    

    // Returns the list of questions
    public static List<String> getQuestions() {
        List<String> questions = new ArrayList<>();

        // Digital Marketing
        questions.add(
                " What is the primary goal of search engine optimization (SEO)?\n(a) Increase website traffic\n(b) Boost social media engagement\n(c) Create compelling content");
        questions.add(
                " What is the purpose of social media marketing?\n(a) Build brand awareness\n(b) Generate online sales\n(c) Improve website performance");
        questions.add(
                " What is the key metric in pay-per-click (PPC) advertising?\n(a) Click-through rate (CTR)\n(b) Impressions\n(c) Conversion rate");
        questions.add(
                " What is the role of content marketing in digital marketing?\n(a) Attract and engage audience\n(b) Optimize website speed\n(c) Manage online advertising campaigns");
        questions.add(
                " What is the purpose of email marketing?\n(a) Nurture leads\n(b) Improve website security\n(c) Optimize ad campaigns");
        questions.add(
                " What is the difference between organic and paid search results?\n(a) Placement on search engine\n(b) Cost to the advertiser\n(c) Click-through rate (CTR)");
        questions.add(
                " What is the purpose of A/B testing in digital marketing?\n(a) Compare two versions of a webpage\n(b) Track website analytics\n(c) Optimize keyword density");
        questions.add(
                " What is the role of analytics in digital marketing?\n(a) Track and measure performance\n(b) Design website layouts\n(c) Manage social media accounts");
        questions.add(
                " What is the purpose of conversion rate optimization (CRO)?\n(a) Increase website conversions\n(b) Enhance user experience\n(c) Optimize website speed");
        questions.add(
                "1 What is the role of influencers in digital marketing?\n(a) Promote products or services\n(b) Manage online ad campaigns\n(c) Create engaging content");

        // Machine Learning
        questions.add(
                " What is machine learning?\n(a) A branch of artificial intelligence\n(b) Human-like robotic systems\n(c) Computer programming");
        questions.add(
                " Which algorithm is commonly used for linear regression?\n(a) Support Vector Machine (SVM)\n(b) K-means clustering\n(c) Ordinary Least Squares (OLS)");
        questions.add(
                " What is the purpose of feature scaling in machine learning?\n(a) Normalize data\n(b) Handle missing values\n(c) Reduce dimensionality");
        questions.add(
                " What is the role of validation data in model training?\n(a) Evaluate model performance\n(b) Select optimal hyperparameters\n(c) Split data into training and testing sets");
        questions.add(
                " What is the difference between supervised and unsupervised learning?\n(a) Presence of labels\n(b) Type of data\n(c) Training time");
        questions.add(
                " Which algorithm is commonly used for image classification?\n(a) Decision Tree\n(b) K-nearest neighbors (KNN)\n(c) Convolutional Neural Network (CNN)");
        questions.add(
                " What is the purpose of regularization in machine learning?\n(a) Prevent overfitting\n(b) Select important features\n(c) Optimize model parameters");
        questions.add(
                " What is the role of cross-validation in model evaluation?\n(a) Estimate model performance\n(b) Handle imbalanced data\n(c) Visualize data distributions");
        questions.add(
                " What is the purpose of ensemble learning?\n(a) Combine multiple models\n(b) Handle missing data\n(c) Optimize model parameters");
        questions.add(
                " What is the role of dimensionality reduction in machine learning?\n(a) Reduce dimensionality\n(b) Handle imbalanced data\n(c) Improve model accuracy");

        // Web Development
        questions.add(
                " What is HTML?\n(a) Hypertext Markup Language\n(b) High-level Programming Language\n(c) Hyperlink and Text Markup Language");
        questions.add(
                " What is CSS used for?\n(a) Styling the web page\n(b) Executing scripts on the web page\n(c) Creating server-side logic");
        questions.add(
                " Which programming language is used for web development?\n(a) Python\n(b) Java\n(c) JavaScript");
        questions.add(
                " What is the purpose of responsive web design?\n(a) Making websites load faster\n(b) Optimizing websites for search engines\n(c) Creating websites that adapt to different screen sizes");
        questions.add(
                " What is the role of Bootstrap in web development?\n(a) CSS framework\n(b) JavaScript library\n(c) Code versioning tool");
        questions.add(
                " What is the purpose of a web server?\n(a) Serving web pages\n(b) Running database queries\n(c) Compiling programming code");
        questions.add(
                " What is the difference between front-end and back-end development?\n(a) User interface design\n(b) Client-server interaction\n(c) Data storage and retrieval");
        questions.add(" Which protocol is used for transferring data over the web?\n(a) HTTP\n(b) FTP\n(c) SSH");
        questions.add(
                " What is the purpose of AJAX in web development?\n(a) Asynchronous data exchange\n(b) Web page navigation\n(c) Server-side scripting");
        questions.add(
                " What is the role of CMS in web development?\n(a) Content management\n(b) Client-side scripting\n(c) Code debugging");

        // Android Development
        questions.add(
                " Which programming language is used for Android app development?\n(a) C#\n(b) Java\n(c) Swift");
        questions.add(
                " What is the purpose of an APK file?\n(a) Install Android apps\n(b) Store app resources\n(c) Compile app source code");
        questions.add(
                " What is an activity in Android app development?\n(a) User interface screen\n(b) Data storage location\n(c) Background process");
        questions.add(
                " What is the role of an intent in Android app development?\n(a) Communication between components\n(b) Display app notifications\n(c) Optimize app performance");
        questions.add(
                " What is the purpose of a fragment in Android app development?\n(a) Reusable UI component\n(b) Manage app permissions\n(c) Store app preferences");
        questions.add(
                " Which layout manager is commonly used in Android app development?\n(a) LinearLayout\n(b) RelativeLayout\n(c) GridLayout");
        questions.add(
                " What is the purpose of SQLite in Android app development?\n(a) Database storage\n(b) Image processing\n(c) Network communication");
        questions.add(
                " What is the role of Gradle in Android app development?\n(a) Build automation\n(b) User interface design\n(c) Code debugging");
        questions.add(
                " What is the purpose of an Android emulator?\n(a) Test apps on virtual devices\n(b) Deploy apps to the Play Store\n(c) Analyze app performance");
        questions.add(
                " What is the role of Android Studio in app development?\n(a) Integrated development environment\n(b) Code versioning tool\n(c) Server-side scripting");

        // Data Science
        questions.add(
                " What is data science?\n(a) Extracting insights from data\n(b) Data storage and retrieval\n(c) Data visualization");
        questions.add(
                " What is the purpose of exploratory data analysis (EDA)?\n(a) Understand data characteristics\n(b) Train machine learning models\n(c) Optimize data storage");
        questions.add(" Which programming language is commonly used in data science?\n(a) R\n(b) C++\n(c) PHP");
        questions.add(
                " What is the role of pandas library in data science?\n(a) Data manipulation\n(b) Neural network training\n(c) Image processing");
        questions.add(
                " What is the purpose of feature engineering in data science?\n(a) Create new features\n(b) Handle missing data\n(c) Visualize data distributions");
        questions.add(
                " What is the difference between correlation and causation?\n(a) Relationship vs. cause-effect\n(b) Continuous vs. categorical data\n(c) Descriptive vs. inferential statistics");
        questions.add(
                " What is the purpose of data preprocessing?\n(a) Clean and transform data\n(b) Split data into training and testing sets\n(c) Train machine learning models");
        questions.add(
                " Which algorithm is commonly used for classification tasks in data science?\n(a) Logistic Regression\n(b) K-means clustering\n(c) Decision Tree");
        questions.add(
                " What is the role of cross-validation in model evaluation?\n(a) Estimate model performance\n(b) Handle missing data\n(c) Visualize data distributions");
        questions.add(
                " What is the purpose of regularization in data science?\n(a) Prevent overfitting\n(b) Reduce model complexity\n(c) Optimize model parameters");

        // Game Development
        questions.add(
                " Which game engine is commonly used for 2D game development?\n(a) Unity\n(b) Unreal Engine\n(c) Godot");
        questions.add(
                " What is the purpose of game assets?\n(a) Graphics, sounds, and models\n(b) Game logic and rules\n(c) Player input and controls");
        questions.add(
                " What is the role of collision detection in game development?\n(a) Detecting object interactions\n(b) Handling player movement\n(c) Rendering game graphics");
        questions.add(
                " What is the purpose of game physics in game development?\n(a) Simulating real-world physics\n(b) Creating game levels\n(c) Managing game assets");
        questions.add(
                " What is the difference between sprite-based and 3D game development?\n(a) 2D vs. 3D graphics\n(b) Game complexity\n(c) Player interaction");
        questions.add(
                " Which programming language is commonly used in game development?\n(a) C++\n(b) Python\n(c) Java");
        questions.add(
                " What is the role of game loops in game development?\n(a) Update game state\n(b) Load game assets\n(c) Handle player input");
        questions.add(
                " What is the purpose of game AI in game development?\n(a) Simulate intelligent behavior\n(b) Handle game physics\n(c) Optimize game performance");
        questions.add(
                " What is the role of game testing in game development?\n(a) Identify bugs and issues\n(b) Design game levels\n(c) Implement game features");
        questions.add(
                " What is the purpose of game monetization strategies?\n(a) Generate revenue from games\n(b) Promote games on social media\n(c) Optimize game performance");

        return questions;
    }

    // Returns the list of answers
    public static List<String> getAnswers() {
        List<String> answers = new ArrayList<>();

        // Digital Marketing
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("b");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");

        // Machine Learning
        answers.add("a");
        answers.add("c");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("c");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");

        // Web Development
        answers.add("a");
        answers.add("a");
        answers.add("c");
        answers.add("c");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");

        // Android Development
        answers.add("b");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("c");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");

        // Data Science
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");

        // Game Development
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");
        answers.add("a");

        return answers;
    }

    // Returns the starting index for a given topic
    public static int topicIndex(String topic) {
        switch (topic) {
            case "Digital Marketing":
                return 0;
            case "Machine Learning":
                return 10;
            case "Web Development":
                return 20;
            case "Android Development":
                return 30;
            case "Data Science":
                return 40;
            case "Game Development":
                return 50;
            default:
                return 0;
        }
    }
}