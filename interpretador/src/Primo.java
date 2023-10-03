public class Primo  {

    public static String TestaPrimo(int x){
        String resPos = "É primo sim fio";
        String resNeg = "Não primo não fio";
        if (x == 1){
            return resNeg;
        }
        for(long i=2; i <= x/2; i++){
            if((x%i)==0) {
                return resNeg;
            }
        }
        return resPos;

    }
}