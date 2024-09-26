import java.util.Scanner;

public class Clock {

    // Constructor that will initialize the time
    public Clock(int hours, int minutes, int seconds) {
        this.hours = (hours % 24 + 24) % 24; // Get hours between 0 and 23
        this.minutes = (minutes % 60 + 60) % 60; // Get minutes between 0 and 59
        this.seconds = (seconds % 60 + 60) % 60; // Get seconds between 0 and 59
        normalizeTime();
    }

    // Normalize the time so that seconds and minutes are within their bounds
    private void normalizeTime() {
        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds %= 60;
        } else if (seconds < 0) {
            minutes += (seconds / 60) - 1;
            seconds = 60 + (seconds % 60);
        }

        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        } else if (minutes < 0) {
            hours += (minutes / 60) - 1;
            minutes = 60 + (minutes % 60);
        }

        hours %= 24;
    }

     // Method to get the current time in "HH:MM:SS" format
     public String getTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // Conversion methods
    public static double secondsToMinutes(int seconds) {
        return seconds / 60.0;
    }

    public static double secondsToHours(int seconds) {
        return seconds / 3600.0;
    }

    public static double minutesToSeconds(int minutes) {
        return minutes * 60.0;
    }

    public static double minutesToHours(int minutes) {
        return minutes / 60.0;
    }

    public static double hoursToSeconds(int hours) {
        return hours * 3600.0;
    }

    public static double hoursToMinutes(int hours) {
        return hours * 60.0;
    }

     // Main method that demonstrate the usage of the Clock class and conversions
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        while (continueConversion) {
            System.out.println("1) Seconds to Minutes");
            System.out.println("2) Seconds to Hours");
            System.out.println("3) Minutes to Seconds");
            System.out.println("4) Minutes to Hours");
            System.out.println("5) Hours to Seconds");
            System.out.println("6) Hours to Minutes");
            System.out.println("Choose the conversion: ");
            int choice = scanner.nextInt();

            System.out.print("Enter the value: ");
            int value = scanner.nextInt();
            double result = 0;

            switch (choice) {
                case 1:
                    result = secondsToMinutes(value);
                    System.out.println(value + " seconds to minutes: " + result);
                    break;
                case 2:
                    result = secondsToHours(value);
                    System.out.println(value + " seconds to hours: " + result);
                    break;
                case 3:
                    result = minutesToSeconds(value);
                    System.out.println(value + " minutes to seconds: " + result);
                    break;
                case 4:
                    result = minutesToHours(value);
                    System.out.println(value + " minutes to hours: " + result);
                    break;
                case 5:
                    result = hoursToSeconds(value);
                    System.out.println(value + " hours to seconds: " + result);
                    break;
                case 6:
                    result = hoursToMinutes(value);
                    System.out.println(value + " hours to minutes: " + result);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            // comments
            System.out.print("Do you want to convert time? (Y/N): ");
            char again = scanner.next().charAt(0);
            continueConversion = (again == 'Y' || again == 'y');
        }

        scanner.close();
    }
}