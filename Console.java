import java.util.Scanner;

class Node {
    String questionOrAnswer;
    Node yesBranch;
    Node noBranch;

    public Node(String questionOrAnswer) {
        this.questionOrAnswer = questionOrAnswer;
    }

    public void setBranches(Node yes, Node no) {
        this.yesBranch = yes;
        this.noBranch = no;
    }
}

public class DecisionHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating the tree
        Node root = new Node("Do you feel tired?");
        Node tiredYes = new Node("Do you want to rest at home?");
        Node tiredNo = new Node("Do you feel like being creative?");

        Node restHome = new Node("Watch a movie and relax!");
        Node goOutside = new Node("Go outside for a walk!");

        Node beCreative = new Node("Try drawing or writing something fun!");
        Node notCreative = new Node("How about calling a friend to chat?");

        // Connecting branches
        root.setBranches(tiredYes, tiredNo);
        tiredYes.setBranches(restHome, goOutside);
        tiredNo.setBranches(beCreative, notCreative);

        // Traversing the tree
        Node current = root;
        while (current.yesBranch != null && current.noBranch != null) {
            System.out.println(current.questionOrAnswer);
            System.out.print("Enter 'yes' or 'no': ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                current = current.yesBranch;
            } else if (answer.equals("no")) {
                current = current.noBranch;
            } else {
                System.out.println("Please type 'yes' or 'no'.");
            }
        }

        // Final suggestion
        System.out.println("\n" + current.questionOrAnswer);
        scanner.close();
    }
}
