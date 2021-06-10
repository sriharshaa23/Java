package ASSIGNMENT3;

import java.util.Scanner;

class Book {

    public int getBookId() {
        return bookId;
    }

    private int bookId;
    private String bookTitle;
    private int yearOfPublication;
    private String nameOfAuthor;
    private String publisherName;
    private int numberOfAvailableCopies;
    private int totalCopies;
    private String issue;
    private String returned;

    public Book(){
    }
    public Book(int totalCopies){
        this.totalCopies=totalCopies;
    }

    public void setDetails(){
        this.bookId=1;
        this.bookTitle="book1";
        this.yearOfPublication=2020;
        this.nameOfAuthor="author1";
        this.publisherName="publisher1";
        this.totalCopies=100;
        this.numberOfAvailableCopies=40;
    }

    public void setDetails(int bookId, String bookTitle, int yearOfPublication, String nameOfAuthor, String publisherName,int numberOfAvailableCopies,int totalCopies){
       this.bookId=bookId;
       this.bookTitle=bookTitle;
       this.yearOfPublication=yearOfPublication;
       this.nameOfAuthor=nameOfAuthor;
       this.publisherName=publisherName;
       this.totalCopies=totalCopies;
       this.numberOfAvailableCopies=numberOfAvailableCopies;
    }

    public String getDetails(int bookId){
     String details = "BookId: " + bookId + " ,BookTitle: "+ this.bookTitle + " ,YearOfPublication: "+ this.yearOfPublication + " ,NameOfAuthor: "+this.nameOfAuthor+" ,Publisher: "+this.publisherName+
                      " ,totalCopies: "+this.totalCopies+" ,availableCopies: "+ this.numberOfAvailableCopies+" ,IssueDate: "+ this.issue+" ,ReturnDate: "+this.returned;
     return details;
    }
    public void issue(String issue){
        this.issue=issue;
    }
    public void returned(String returned){
        this.returned=returned;
    }
}

public class Main {

    public static void main(String[] args) {
        Book[] books = new Book[12];
        for(int i=0;i<12;i++)
            books[i]= new Book();
        books[0].setDetails();
        books[1].setDetails(2,"book2",2019,"author2","publisher2",40,4);
        books[2].setDetails(3,"book3",2017,"author3","publisher3",97,45);
        books[3].setDetails(4,"book4",2018,"author4","publisher2",48,2);
        books[4].setDetails(5,"book5",2015,"author5","publisher3",70,40);
        Scanner sc= new Scanner(System.in);
        sc.close();
        int bookId;
        String bookTitle;
        int yearOfPublication;
        String nameOfAuthor;
        String publisherName;
        int numberOfAvailableCopies;
        int totalCopies;
        String issue;
        String returnDate;
        while(true) {
            System.out.println("Enter the option:");
            int menuOption = sc.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.println("Enter bookId: ");
                    bookId= sc.nextInt();
                    System.out.println("Enter bookTitle: ");
                    bookTitle= sc.next();
                    System.out.println("Enter yearOfPublication: ");
                    yearOfPublication= sc.nextInt();
                    System.out.println("Enter nameOfAuthor: ");
                    nameOfAuthor= sc.next();
                    System.out.println("Enter publisherName ");
                    publisherName= sc.next();
                    System.out.println("Enter totalCopies ");
                    totalCopies= sc.nextInt();
                    System.out.println("Enter availableCopies ");
                    numberOfAvailableCopies= sc.nextInt();
                    for(int i=0;i<12;i++) {
                        if(books[i].getBookId()==0)
                        books[bookId-1].setDetails(bookId, bookTitle, yearOfPublication, nameOfAuthor, publisherName, numberOfAvailableCopies, totalCopies);
                    }
                    for(int i=0;i<12;i++){
                        if(books[i].getBookId()==bookId)
                            System.out.println(books[i].getDetails(bookId));
                    }
                    break;
                case 2:
                    System.out.println("Enter bookId: ");
                    bookId=sc.nextInt();
                    for(int i=0;i<12;i++){
                        if(books[i].getBookId()==bookId)
                            System.out.println(books[i].getDetails(bookId));
                    }
                    break;
                case 3:
                    System.out.print("Enter bookId: ");
                    bookId= sc.nextInt();
                    System.out.println("Enter Issue Date: ");
                    issue=sc.next();
                    for(int i=0;i<12;i++){
                        if(books[i].getBookId()==bookId)
                            books[i].issue(issue);
                    }
                    for(int i=0;i<12;i++){
                        if(books[i].getBookId()==bookId)
                            System.out.println(books[i].getDetails(bookId));
                    }
                    break;
                case 4:
                    System.out.print("Enter bookId: ");
                    bookId= sc.nextInt();
                    System.out.println("Enter return Date: ");
                    returnDate=sc.next();
                    for(int i=0;i<12;i++){
                        if(books[i].getBookId()==bookId)
                            books[i].returned(returnDate);
                    }
                    for(int i=0;i<12;i++){
                        if(books[i].getBookId()==bookId)
                            System.out.println(books[i].getDetails(bookId));
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}