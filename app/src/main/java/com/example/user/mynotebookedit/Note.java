package com.example.user.mynotebookedit;

public class Note {
    private String title, message;
    private long noteId, dateCreatedMilli;
    private Category category;


    public enum Category { PERSONAL, WORK, PRIVATE, FINANCIAL }

    public Note(String title, String message, Category category){
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = 0;
        this.dateCreatedMilli = 0;
    }

    public Note(String title, String message, Category category, long noteId, long dateCreatedMilli){
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;
    }

    public String getTitle(){
        return title;
    }

    public String getMessage(){
        return message;
    }

    public Category getCategory(){
        return category;
    }

    public long getDate() { return dateCreatedMilli; }

    public long getId() { return noteId; }

    public String toString() {
        return "ID: " + noteId + " Title: " + title + " Message: " + message + " IconID: " + category.name() + " Date: ";
    }

    public int getAssociatedDrawable(){
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category noteCategory){

        switch(noteCategory){
            case PERSONAL:
                return R.drawable.a;
            case WORK:
                return R.drawable.b;
            case PRIVATE:
                return R.drawable.c;
            case FINANCIAL:
                return R.drawable.d;
        }

        return R.drawable.a;
    }

}
