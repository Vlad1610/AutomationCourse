package ro.sit.course.Course05;

import ro.sit.course.course03_04.Person;

import java.util.*;
import java.util.jar.JarEntry;
public class Course05 {
    String phrase = "Through Java Collections API we have set of classes and interfaces providing collections of" +
            " objects with more advanced behavior than arrays." +
            "Java Collections can achieve all the operations that you perform on a data such as searching," +
            " sorting, insertion, manipulation, and deletion.";

    public static void main(String[] args) {
        Course05 course05 = new Course05();
        Truck truck = new Truck();
        truck.engineOn();
        Dacia dacia = new Dacia();
        dacia.start();
// collections
        int[] list = {1, 2, 3, 5};
        System.out.println(list[2]);

        Person[] people = {new Person("Ion", (byte) 10, "m", "1112345678903"),
                new Person("Maria", (byte) 20, "f", "2122345678912")};

        for(int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
//            System.out.println("Nume:"+people[i].getName()+"->cnp:"+people[i].getCnp());
        }
        System.out.println("Equivalent display of list values:");
//       equivalent for
//   tipElemList numeVariabila : numeLista
        for (Person p : people)
            System.out.println(p);

        int[] listNew = new int[5];
        listNew[0] = 3;
        listNew[4] = 1;

        course05.workWithlists();
        course05.workWithSets();
        course05.workWithHashMap();

//        display words with his recurrences from phrase
        HashMap<String, Integer> workCount = course05.getMapWithWords(
                course05.getAllWords(course05.phrase));
        course05.showHashMap(workCount);
        course05.workWithQueue();

//        enums
        System.out.println(Browsers.CHROME);
        List<String> browsers = new ArrayList<>();
        browsers.add("Chrome");
        browsers.add("Edge");

        if (browsers.get(1).equalsIgnoreCase(Browsers.CHROME.toString()))
            System.out.println("Browser are the same:" + Browsers.CHROME);
    }

    public void workWithlists() {
        List list = new ArrayList();
        list.add(1);
        list.add("Ion");
        list.add(new Person("Ion", (byte) 10, "m", "1112345678903"));
        displayList(list);

        List<String> names = new ArrayList<>();
        names.add("Ion");
        names.add("Maria");
        names.add("Vasile");
        names.add("Ion");
        names.remove("Ion");

        System.out.println("Are 2 lists equals: list and names->" + list.equals(names));
        System.out.println("Element on first poz:" + names.get(0));
        System.out.println("Name has Ion on list?" + names.contains("Ion"));
        displayList(names);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Ion", (byte) 10, "m", "1112345678903"));
        people.add(new Person("Maria", (byte) 20, "f", "2122345678912"));

        for (Person p : people)
            System.out.println(p);
    }

    public void workWithSets() {
        System.out.println("Work with SETS");
        HashSet<String> setList = new HashSet<>();
        setList.add("Ion");
        setList.add("Vasile");
        setList.add("Ion");
        HashSet<String> copySet = (HashSet<String>) setList.clone();
        System.out.println("CopySet equals with setList? " + copySet.equals(setList));

        for (String el : setList) {
            System.out.println(el);
        }
    }

    public void workWithHashMap() {
        System.out.println("Work with hashmap");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("test", "test def");
        hashMap.put("nemurire", "imortalitate");
        hashMap.put("ok", "bine");
        hashMap.put("complex", "complicat");
        hashMap.put("ok", "e bine de tot");

        System.out.println(hashMap.get("test"));
        showHashMap(hashMap);
    }

    public void workWithQueue() {
        Queue<Integer> q = new LinkedList<>();
        q.add(56);
        q.add(101);
        q.add(69);
        q.add(23);
        System.out.println("Queue first:" + q);
        q.remove();
        System.out.println("Queue after remove:" + q);
    }

    public void displayList(List list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public void showHashMap(HashMap map) {
        for (Object key : map.keySet()) {
            System.out.println(key + "->" + map.get(key));
        }
    }


    public List<String> getAllWords(String phrase) {
        List<String> words = new ArrayList<>();
        String[] splitWords = phrase.split(" |\\.|, ");

        //words.addAll(Arrays.asList(splitWords));
        for (String el : splitWords)
            words.add(el.toLowerCase());

        return words;
    }

    public HashMap<String, Integer> getMapWithWords(List<String> words) {
        HashMap<String, Integer> wordsCount = new HashMap<>();
        for (String word : words)
            if (wordsCount.containsKey(word)) {
                Integer count = wordsCount.get(word);
                count++;
                wordsCount.put(word, count);
            } else
                wordsCount.put(word, 1);
        return wordsCount;
    }
}
