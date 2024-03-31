import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RowLocalizedDemo {

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/row_localization";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Test12";

    // ResourceBundle for localized strings
    private static ResourceBundle messages;

    public static void main(String[] args) {
        // Load messages for the default locale (English)
        messages = ResourceBundle.getBundle("messages", Locale.getDefault());

        // Prompt the user to select a language
        selectLanguage();

        // Connect to the database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Insert localized strings
            insertLocalizedStrings(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a language:");
        System.out.println("1. English");
        System.out.println("2. Japanese");
        System.out.println("3. Farsi");
        int choice = scanner.nextInt();

        // Set the default locale based on user's choice
        switch (choice) {
            case 1:
                Locale.setDefault(new Locale("en", "US"));
                break;
            case 2:
                Locale.setDefault(new Locale("ja", "JP"));
                break;
            case 3:
                Locale.setDefault(new Locale("fa", "IR")); // Farsi locale
                break;
            default:
                System.out.println("Invalid choice. Defaulting to English.");
                Locale.setDefault(Locale.ENGLISH);
        }

        // Load messages for the selected locale
        messages = ResourceBundle.getBundle("messages", Locale.getDefault());
    }

    private static void insertLocalizedStrings(Connection conn) throws SQLException {
        try {
            // Prepare the SQL statement to insert localized strings
            String sql = "INSERT INTO localized_strings (language_code, message) VALUES (?, ?)";

            // English message
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "en");
                stmt.setString(2, "rubbish");
                stmt.executeUpdate();
            }

            // Japanese message
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "ja");
                stmt.setString(2, "出放題");
                stmt.executeUpdate();
            }

            // Farsi message
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "fa");
                stmt.setString(2, "چیز پست و بی ارزش");
                stmt.executeUpdate();
            }

            System.out.println("Localized strings inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
