import java.lang.reflect.Array;
import java.util.Arrays;

public class gen_arr {
    int size;
    int  arr [];

    obj_el mass [];

    public void gen_arr(){
        arr = new int [size];
        for (int i=0;i<size;i++){
            arr[i]= rand();
        }
        output_arr();
        step_1();
    }
    public  int rand (){
        int number;
        number = (int)(5+Math.random()*(15));
        return number;
    }

    public void output_arr(){
        System.out.println("*** INPUT ***");

        for (int i=0;i<size;i++){
            System.out.print("["+arr[i]+"]");
        }
    }

    public void step_1(){
        mass = new obj_el[size];
        for (int i=0;i<size;i++){
            int hash = hash(arr[i]);
                if (mass[hash] ==  null) {
                    mass[hash] = new obj_el();
                    mass[hash].value = arr[i];
                    mass[hash].count = 1;
                }else {
                    if((int)mass[hash].value == arr[i]){
                    mass[hash].count++;}
                    else {
                        while (mass[hash]!=null){
                            if (hash!=size-1){
                            hash++;}else hash=0;
                        }
                        mass[hash] = new obj_el();
                        mass[hash].value = arr[i];
                        mass[hash].count = 1;

                    }
            }
        }
        del_null();
        sort();
        output();
    }

    public void del_null(){
        int index=0;
        for (int i=0;i<size; i++){
            if (mass[i]!=null){
                mass[index]=mass[i];
                index++;
            }
        }
        size = index;
    }


    public void sort(){
        for (int i=1;i<size;i++){
            int index = i;
            while ((index>0)&&(mass[index].count>=mass[index-1].count)){
                if (mass[index].count!=mass[index-1].count){
                swap(index,index-1);
                index--;}
                else{
                    if ((int)mass[index].value<(int)mass[index-1].value){
                        swap(index,index-1);
                        index--;}
                    else {index=0;}
                }
            }
        }
    }

    public  void swap(int x, int y){
        obj_el i= mass[x];
        mass[x] = mass[y];
        mass[y] = i;
    }

    public void output(){
        System.out.println();
        System.out.println("*** OUTPUT ***");
        for (int i=0; i<size;i++){
            for (int j=0; j<mass[i].count;j++){
                System.out.print("["+mass[i].value+"]");
            }
        }
    }

    public int hash(Object key)
    {
        return ( key.hashCode() & 0x7fffffff) % size;
    }

}
