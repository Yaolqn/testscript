//封装(setter&getter)
public class Enemy {
    private String Name;
    private int Damage;

    public Enemy(String name, int damage){
        this.setName(name);
        this.setDamage(damage);
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        if(name != null && !name.trim().isEmpty()){
            this.Name = name;
        }else{
            System.out.println("名字不能为空!");
        }
    }

    public int getDamage(){
        return Damage;
    }

    public void setDamage(int damage){
        if(damage >= 0 && damage <= 100){
            this.Damage = damage;
        }else{
            System.out.println("伤害必须为0-100");
        }
    }

    public void displayInfo(){
        System.out.println("姓名:" + Name + " , 伤害:" + Damage);
    }

    public static void main(String[] args){
        Enemy Enemy_1 = new Enemy("Dark Zibasa", 100);
        Enemy_1.displayInfo();

        Enemy_1.setName("Sadan");
        Enemy_1.setDamage(1);
        Enemy_1.displayInfo();
    }
}