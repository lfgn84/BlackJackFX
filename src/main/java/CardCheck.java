//import java.util.ArrayList;
//import java.util.Collections;
//
//public class CardCheck {
//
//private int soft;
//
//    public int aceValue(int total, Card card ) {
////        total += card.getValue();
//            if(card.getRank() == Rank.ESS){
//                soft += 1;
//            }
//            if(soft > 0){
//                if(total > 21){
//                    total -= 10;
//                    soft -= 1;
//                }
//        }
//            return cardValue;
//    }
//
//    public void discardHand() {
//        hand.clear();
//        total = 0;
//        soft = 0;
//    }
//
//    public int getNumberOfCards() {
//        return hand.size();
//    }
//
//    public void sort() {
//        Collections.sort( hand );
//    }
//
//    public boolean isEmpty() {
//        return hand.isEmpty();
//    }
//
//    public int findCard( Card card ) {
//        return hand.indexOf( card );
//    }
//
//    public int getSoft(){
//        return soft;
//    }
//
//    public int evaluateHand(){
//        return total;
//    }
//
//    @Override
//    public String toString() {
//        return hand.toString();
//    }
//
//
//}
