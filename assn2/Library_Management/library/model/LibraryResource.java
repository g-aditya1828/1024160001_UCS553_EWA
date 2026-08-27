package library.model;

public abstract class LibraryResource {

    private int resourceId;
    private String title;
    private String author;

    protected static String libraryName = "Smart University Library";

    private static int resourceCount = 0;

    // Constructor
    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;

        resourceCount++;
    }

    // Public getters
    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Protected method
    protected void displayBasicDetails() {
        System.out.println("Library Name : " + libraryName);
        System.out.println("Resource ID  : " + resourceId);
        System.out.println("Title        : " + title);
        System.out.println("Author       : " + author);
    }

    // Abstract method
    public abstract double calculateFine(int overdueDays);

    // Static method
    public static void displayTotalResources() {
        System.out.println("Total Resources Created: " + resourceCount);
    }
}