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
      else if ( cmd.startsWith("article detail ") ) {
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[2]); // "1" => 1

        // article detail 1
        Article foundArticle = null;

        for ( int i = 0; i < articles.size(); i++ ) {
          Article article = articles.get(i);

          if ( article.id == id ) {
            foundArticle = article;
            break;
          }
        }

        if ( foundArticle == null ) {
          System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
          continue;
        }

        System.out.printf("번호 : %d\n", foundArticle.id);
        System.out.printf("날짜 : %s\n", "2025-12-12 12:12:12");
        System.out.printf("제목 : %s\n", foundArticle.title);
        System.out.printf("내용 : %s\n", foundArticle.body);
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