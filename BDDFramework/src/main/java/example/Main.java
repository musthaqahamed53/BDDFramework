package example;
//import io.cucumber.core.cli.Main;
public class Main {
	public static void main(String[] args) {
		System.out.println("Starting Cucumber tests...");

		// Running the Cucumber tests with the specified arguments
		String[] cucumberArgs = { "--plugin", "pretty", // Output format (pretty-print)
				"--glue", "stepdefinitions", // Glue code location (step definitions package)
				"src/test/resources/features" // Path to feature files
		};

		// This will execute the Cucumber tests
		io.cucumber.core.cli.Main.main(cucumberArgs);
	}
}
