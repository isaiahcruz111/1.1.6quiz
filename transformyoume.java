  /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //will remove final period
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);       
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        if(statement.substring(psnOfMe + 2).length() > 0) {
            return "What makes you think that I " + restOfStatement + " you" + statement.substring(psnOfMe + 2) + "?";
        }
        else {
            return "What makes you think that I " + restOfStatement + " you?";
        }
    }