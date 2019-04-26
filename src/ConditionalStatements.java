class ConditionalStatements {
    public static void main(String[] args) {
        // test if / else
        int answer = 17;
        int correctAnswer = 13;
        int score = 0;
        if (answer == correctAnswer) {
            score += 10;
            System.out.println("That’s right. You get 10 points");
        } else {
            score -= 5;
            System.out.println("Sorry, that’s wrong. You lose 5 points");
        }
        
        // test if else if
        char grade='B';
        if (grade == 'A') {
            System.out.println("You got an A. Great job!");
        } else if (grade == 'B') {
            System.out.println("You got a B. Good work!");
        } else if (grade == 'C') {
            System.out.println("You got a C. What went wrong?");
        } else {
            System.out.println("You got an F. You’ll do well in Congress!");
        }
        
        grade='C';
        switch (grade) {
            case 'A' : case 'a':
                System.out.println("You got an A. Great job!");
                break;
            case 'B':case 'b':
                System.out.println("You got a B. Good work!");
                break;
            case 'C':case 'c':
                System.out.println("You got a C. What went wrong?");
                break;
            default:
                System.out.println("You got an F. You’ll do well in Congress!");
        }
    }
}