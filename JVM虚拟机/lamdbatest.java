public class LambdaTest {

    @Test
    public void testArraySort() {
        List<Student> studentArr = new ArrayList();
        Student xiaoming = new Student("xiaoming", 87);
        Student xiaohong = new Student("xiaohong", 90);
        Student xiaoqiang = new Student("xiaoqiang", 90);
        studentArr.add(xiaoming);
        studentArr.add(xiaohong);

        // 排序
//        studentArr.sort((Student s1, Student s2) -> (s1.grade > s2.grade) ? -1 : 1);
        // 逆序排序的更好实现方式
        studentArr.sort(Comparator.comparing(Student::getGrade).reversed().thenComparing(Student::getName));
        studentArr.forEach(System.out::println);

        // 分组
        List<Integer> gradeGroup = studentArr.stream().collect(Collectors.groupingBy(Student::getGrade)).keySet().stream().collect(Collectors.toList());
        gradeGroup.forEach(System.out::println);

        // 过滤
        Predicate<Student> niceGrade = (Student s) -> s.grade >= 90;
        Predicate<Student> passGrade = (Student s) -> s.grade >= 60;
        //studentArr = studentArr.stream().filter((Student s) -> s.grade >= 90).collect(Collectors.toList());
        // 筛选出60~89 分的同学
        studentArr = studentArr.stream().filter(niceGrade.negate().and(passGrade)).collect(Collectors.toList());
        studentArr.forEach(System.out::println);
    }

    @Test
    public void testFuntion() {
        Function<Integer, Apple> appleMaker = Apple::new;
        Apple anApple = appleMaker.apply(10);
        System.out.println("我的苹果重量为：" + anApple.getWeight());
    }

    @Data
    @AllArgsConstructor
    private static class Student {
        private String name;

        private int grade;

        @Override
        public String toString() {
            return String.format("名字: %s, 成绩: %d", this.name, this.grade);
        }
    }

    @Data
    @AllArgsConstructor
    private static class Apple {
        private int weight;
    }

}

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.6.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>

        <!-- lambok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.6</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
