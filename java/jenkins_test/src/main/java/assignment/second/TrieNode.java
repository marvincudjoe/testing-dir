package assignment.second.revised;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TrieNode {
    /* Represents non-leaves of the Tree */
    boolean isEnd;
    TrieNode parent;
    char getChar;
    int count;
    LinkedList<TrieNode> children;

    TrieNode(char c) {
        isEnd = false;
        getChar = c;
        count = 0;
        children = new LinkedList<>();
    }

    /**.
     * Method for part 2
     *
     * @param c - a character from a char array or
     * @return returns the child if the node exists
     *      Returns null if there's no child of the node
     */
    public TrieNode innerChild(char c) {
        if (children != null && !children.isEmpty()) {
            for (TrieNode child : children) {
                if (child.getChar == c) {
                    return child;
                }
            }
        }
        return null;
    }

    /**.
     * @return An array of characters as a String
     */
    String charToString() {
        return parent == null ?  "" : parent.charToString() + getChar;
    }

    /**.
     * Recursive method that generates the list of words required for the getWords method()
     * @return an Arraylist of words
     */
    List<String> listOfWords() {
        List<String> wordList = new ArrayList<>();

        if (isEnd) {
            wordList.add(charToString());
        }
        if (children != null) {
            for (TrieNode child : children) {
                if (child != null) {
                    wordList.addAll(child.listOfWords());
                }
            }
        }
        wordList.sort(Comparator.naturalOrder());
        return wordList;
    }

}
