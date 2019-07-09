package ru.lebedev.se.lesson2.persons;

class PersonArray {
    private Person[] arr;
    private int size;

    public PersonArray(int size) {
        this.arr = new Person[size];
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i].getName() + " " + arr[i].getAge());
        }
    }

    // Поиск ------------------------------------------------------------------------------------------------------

    public boolean find(String search) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getName().equals(search)) return true;
        }
        return false;
    }

    // Удаление ---------------------------------------------------------------------------------------------------

    public void delete(String search) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (arr[i].getName().equals(search)) break;
        }

        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }
        size--;
    }

    // Вставка ----------------------------------------------------------------------------------------------------

    public void insert(String name, int age) {
        arr[size] = new Person(name, age);
        size++;
    }

    // Сортировка пузырьком ---------------------------------------------------------------------------------------

    public void sortBubbleByName() {
        int out, in;
        for (out = size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in].getName().compareTo(arr[in + 1].getName()) > 0) {
                    change(in, in + 1);
                }
            }
        }
    }

    public void sortBubbleByAge() {
        int out, in;
        for (out = size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in].getAge() > (arr[in + 1].getAge())) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b) {
        Person tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // Сортировка выбором -----------------------------------------------------------------------------------------

    public void sortSelectByName() {
        int out, in, mark;
        for (out = 0; out < size; out++) {
            mark = out;
            for (in = out + 1; in < size; in++) {
                if (arr[in].getName().compareTo(arr[mark].getName()) < 0) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }

    public void sortSelectByAge() {
        int out, in, mark;
        for (out = 0; out < size; out++) {
            mark = out;
            for (in = out + 1; in < size; in++) {
                if (arr[in].getAge() < (arr[mark].getAge())) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }
    // Сортировка вставкой ---------------------------------------------------------------------------------------

    public void sortInsertPersonByName() {
        int in, out;
        for (out = 1; out < size; out++) {
            Person temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1].getName().compareTo(temp.getName()) > 0) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }

    public void sortInsertPersonByAge() {
        int in, out;
        for (out = 1; out < size; out++) {
            Person temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1].getAge() > (temp.getAge())) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }

}

