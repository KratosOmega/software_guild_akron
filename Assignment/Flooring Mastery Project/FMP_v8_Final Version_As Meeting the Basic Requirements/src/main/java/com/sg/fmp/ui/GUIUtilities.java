/*
 * For further development, this class can be added with more private class,
 * then initialized with key values for pre-defined width, wallThickness, etc.
    
 * For further development, this class can be added with more private class,
 * Then user can call the method directly without passing the key values, 
 * but only the changing values such as contents, title, etc.
    
 * Thus, the GUI system can share the constant and stable performance, 
 * like same width, same pattern of building style, etc
    
 * This is open source, so welcome to customize it and let me know plz~~~
    
 * --- OMEGA   
*/ 

package com.sg.fmp.ui;

/**
 *
 * @author Kratos
 */
public class GUIUtilities {
    

    // ------------------------------------------ OS GUI Utilities
    // --- Building Any 1 line compoment ---
    public String os_Component_Builder(String buildingBlock, int amount) {
        String component = "";
        for (int i = 0; i < amount; i++) {
            component += buildingBlock;
        }
        return component;
    }

    // --- Building Menu Block ---
    public String os_Menu_Builder(int width, int wallThickness, String buildingBlock, int paddingWidth, String splitter, String title, String contents) {
        String menu = "";
        String formattedBorder = "";
        String wall = "";
        String padding = "";
        String fillInRest = "";
        String formattedTitile = "";
        String formattedContents = "";
        String titlePaddingLeft = "";
        String titlePaddingRight = "";
        int titlePaddingCount = 0;
        int contentWidth = 0;
        int restSpaces = 0;

        //Get content in a list (array)
        String[] contentList = contents.split(splitter);
        //Construct border
        formattedBorder = os_Component_Builder(buildingBlock, width);
        //Construct wall
        wall = os_Component_Builder(buildingBlock, wallThickness);
        //Construct padding
        padding = os_Component_Builder(" ", paddingWidth);
        contentWidth = width - wallThickness * 2 - paddingWidth * 2;

        //Construct Content Section
        for (int i = 0; i < contentList.length; i++) {
            restSpaces = contentWidth - contentList[i].length();
            fillInRest = os_Component_Builder(" ", restSpaces);
            formattedContents += "\n" + wall + padding + contentList[i] + fillInRest + padding + wall;
        }

        if (width % 2 == 0) {
            if (title.length() % 2 == 0) {
                titlePaddingCount = (width - title.length() - wallThickness * 2) / 2;
                titlePaddingLeft = os_Component_Builder(" ", titlePaddingCount);
                titlePaddingRight = titlePaddingLeft;
            } else {
                titlePaddingCount = (width - title.length() - 1 - wallThickness * 2) / 2;
                titlePaddingLeft = os_Component_Builder(" ", titlePaddingCount);
                titlePaddingRight = titlePaddingLeft + " ";
            }
        } else if (title.length() % 2 == 0) {
            titlePaddingCount = (width - title.length() - 1 - wallThickness * 2) / 2;
            titlePaddingLeft = os_Component_Builder(" ", titlePaddingCount);
            titlePaddingRight = titlePaddingLeft + " ";
        } else {
            titlePaddingCount = (width - title.length() - wallThickness * 2) / 2;
            titlePaddingLeft = os_Component_Builder(" ", titlePaddingCount);
            titlePaddingRight = titlePaddingLeft;
        }

        formattedTitile = wall + titlePaddingLeft + title + titlePaddingRight + wall;

        menu = formattedBorder + "\n" + formattedTitile + "\n" + formattedBorder + formattedContents + "\n" + formattedBorder;
        return menu;
    }

    // --- Building Notification Block ---
    public String os_Notification_Builder(int width, int wallThickness, String buildingBlock, int paddingWidth, String splitter, String contents) {
        String notification = "";
        String formattedBorder = "";
        String wall = "";
        String formattedContents = "";
        String contentPaddingLeft = "";
        String contentPaddingRight = "";
        int contentPaddingCount = 0;

        formattedBorder = os_Component_Builder(buildingBlock, width);
        wall = os_Component_Builder("*", wallThickness);

        //Get content in a list (array)
        String[] contentList = contents.split(splitter);

        //Construct Content Section
        for (int i = 0; i < contentList.length; i++) {

            if (width % 2 == 0) {
                if (contentList[i].length() % 2 == 0) {
                    contentPaddingCount = (width - contentList[i].length() - wallThickness * 2) / 2;
                    contentPaddingLeft = os_Component_Builder(" ", contentPaddingCount);
                    contentPaddingRight = contentPaddingLeft;
                } else {
                    contentPaddingCount = (width - contentList[i].length() - 1 - wallThickness * 2) / 2;
                    contentPaddingLeft = os_Component_Builder(" ", contentPaddingCount);
                    contentPaddingRight = contentPaddingLeft + " ";
                }
            } else if (contentList[i].length() % 2 == 0) {
                contentPaddingCount = (width - contentList[i].length() - 1 - wallThickness * 2) / 2;
                contentPaddingLeft = os_Component_Builder(" ", contentPaddingCount);
                contentPaddingRight = contentPaddingLeft + " ";
            } else {
                contentPaddingCount = (width - contentList[i].length() - wallThickness * 2) / 2;
                contentPaddingLeft = os_Component_Builder(" ", contentPaddingCount);
                contentPaddingRight = contentPaddingLeft;
            }

            formattedContents += "\n" + wall + contentPaddingLeft + contentList[i] + contentPaddingRight + wall;
        }

        notification = formattedBorder + formattedContents + "\n" + formattedBorder;

        return notification;
    }

    // This is 1 line header to display current operation name
    public String os_Header_Builder(int width, String buildingBlockLeft, String buildingBlockRight, int paddingWidth, String contents) {
        String header = "";
        String left = "";
        String right = "";
        String paddingLeft = "";
        String paddingRight = "";
        int headerThickness = 0;

        headerThickness = (width - paddingWidth * 2 - (contents.length() + contents.length() % 2)) / 2;

        left = os_Component_Builder(buildingBlockLeft, headerThickness);
        right = os_Component_Builder(buildingBlockRight, headerThickness);
        paddingLeft = os_Component_Builder(" ", paddingWidth);
        paddingRight = os_Component_Builder(" ", paddingWidth);

        if (contents.length() % 2 == 1) {
            contents += " ";
        }

        header = left + paddingLeft + contents + paddingRight + right;

        return header;
    }

    // Quick Builder
    public String os_Quick_Menu_Builder(String title, String splitter, String contents) {
        return os_Menu_Builder(100, 5, "*", 10, splitter, title, contents);
    }

    public String os_Quick_Header_Builder(String contents) {
        return os_Header_Builder(100, ">", "<", 5, contents);
    }

    public String os_Quick_Notification_Builder(String splitter, String contents) {
        return os_Notification_Builder(100, 5, "-", 10, splitter, contents);
    }
}
