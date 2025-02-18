package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("== 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);

    List<Article> articles = new ArrayList<>();

    int lastArticleId = 0;

    while ( true ) {
      System.out.print("명령어) ");
      String cmd = sc.nextLine();
      cmd = cmd.trim();

      if ( cmd.length() == 0 ) {
        continue;
      }

      if ( cmd.equals("exit") ) {
        break;
      }
      else if ( cmd.equals("article list") ) {
        if (articles.size() == 0 ) {
          System.out.println("게시물이 없습니다.");
          continue;
        }

        System.out.println("번호 | 제목");
        for ( int i = articles.size() - 1; i >= 0; i-- ) {
          Article article = articles.get(i);

          System.out.printf("%d | %s\n", article.id, article.title);
        }

      }
      else if ( cmd.equals("article write") ) {
        int id = lastArticleId + 1;
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String body = sc.nextLine();

        lastArticleId = id;
        Article article = new Article(id, title, body);

        articles.add(article);

        System.out.printf("%d번 글이 작성되었습니다.\n", id);
      }
    }

    sc.close();
    System.out.println("== 프로그램 끝 ==");
  }
}

class Article {
  int id;
  String title;
  String body;

  public Article (int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }
}