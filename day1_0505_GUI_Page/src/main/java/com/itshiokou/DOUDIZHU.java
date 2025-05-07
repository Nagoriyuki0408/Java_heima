package com.itshiokou;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
public class DOUDIZHU {
    private static final String[] suits={"o1e", "two", "three", "four"};
    private static final String[] ranks={"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    private static final String[] jokers={"big", "small"};


    public static List<String> createDeck(){
        List<String> desk=new ArrayList<>();
        for(String suit:suits){
            for(String rank:ranks){
                desk.add(suit+rank);
            }
        }
        desk.add(jokers[0]);
        desk.add(jokers[1]);
        return desk;
    }
//创建卡牌
    public static void shuffleDeck(List<String>desk){
        Collections.shuffle(desk);
    }
    //洗牌操作
    public static List<List<String>> dealCards(int playernumbers, int cardsPerPlayer,List<String>desk){
        List<List<String>> playersCards=new ArrayList<>();
        for(int i=0;i<playernumbers;i++){
            playersCards.add(new ArrayList<>());
        }
        //字符串序列，每个人的手牌
        int cardIndex=0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < playernumbers; j++) {
                playersCards.get(j).add(desk.get(cardIndex++));
            }
        }
        //整型数字，用来给每个人的手牌进行发牌操作
        return playersCards;
    }
//给每个人发牌
    public static void main(String[] args){
        int playernumbers=3;
        int cardsPerPlayer=17;
        List<String> desk=createDeck();
        shuffleDeck(desk);
        List<List<String>>playdeck=dealCards(playernumbers,cardsPerPlayer,desk);
        for (int i = 0; i < playernumbers; i++) {
            System.out.println("Player " + (i + 1) + "'s cards: " + playdeck.get(i));
        }
        List<String> remainingCards=desk.subList(playernumbers * cardsPerPlayer, desk.size());
        System.out.println("Remaining cards : " + remainingCards);

    }
}
