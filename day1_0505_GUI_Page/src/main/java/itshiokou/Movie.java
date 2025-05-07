package itshiokou;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String name;
    double price;
    int id;

    public Movie(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public void show() {
        System.out.println("the name of the movie is:" + this.name);
        System.out.println("the price of the movie is:" + this.price);
        System.out.println("the id of the movie is:" + this.id);
    }

    public String getname() {
        return this.name;
    }

    public int getid() {
        return this.id;
    }

    public double getprice() {
        return this.price;
    }

    public void id_show(int id) {
        System.out.println("the name of the movie is:" + this.name);
        System.out.println("the price of the movie is:" + this.price);
    }

    // 新增函数：根据电影编号查询电影信息
    public static Movie findMovieById(List<Movie> movies, int id) {
        for (Movie movie : movies) {
            if (movie.getid() == id) {
                return movie;
            }
        }
        return null; // 如果找不到对应 id 的电影，则返回 null
    }

    public static void main(String[] args) {
        Movie m1 = new Movie("Spirited Away", 39.9, 101);
        Movie m2 = new Movie("Inception", 49.5, 102);
        Movie m3 = new Movie("The Matrix", 45.0, 103);

        // 将电影对象放入 List 中
        List<Movie> movieList = new ArrayList<>();
        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);

        // 需求 1：根据 id 查询电影信息
        int searchId = 102;
        Movie foundMovie = findMovieById(movieList, searchId);

        if (foundMovie != null) {
            System.out.println("Found Movie with ID " + searchId + ":");
            foundMovie.show();
        } else {
            System.out.println("Movie with ID " + searchId + " not found.");
        }

        // 需求 2：查询所有电影的名称
        System.out.println("\nAll Movie Names:");
        for (Movie movie : movieList) {
            System.out.println(movie.getname());
        }
    }
}