package ru.lebedev.se.lesson2.persons;

class PersonArray {
    private Person[] arr;
    private int size;

    public PersonArray(int size) {
        this.arr = new Person[size];
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i].getName() + " " + this.arr[i].getAge());
        }
    }

    // Поиск ------------------------------------------------------------------------------------------------------

    public boolean find(String search) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i].getName().equals(search)) break;
        }
        if (i == this.size)
            return false;
        else
            return true;
    }

    // Удаление ---------------------------------------------------------------------------------------------------

    public void delete(String search) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i].getName().equals(search)) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    // Вставка ----------------------------------------------------------------------------------------------------

    public void insert(String name, int age) {
        this.arr[this.size] = new Person(name, age);
        this.size++;
    }

    // Сортировка пузырьком ---------------------------------------------------------------------------------------

    public void sortBubbleByName() {
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (this.arr[in].getName().compareTo(this.arr[in + 1].getName()) > 0) {
                    change(in, in + 1);
                }
            }
        }
    }

    public void sortBubbleByAge() {
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (this.arr[in].getAge() > (this.arr[in + 1].getAge())) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b) {
        Person tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    // Сортировка выбором -----------------------------------------------------------------------------------------

    public void sortSelectByName() {
        int out, in, mark;
        for (out = 0; out < this.size; out++) {
            mark = out;
            for (in = out + 1; in < this.size; in++) {
                if (this.arr[in].getName().compareTo(this.arr[mark].getName()) < 0) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }

    public void sortSelectByAge() {
        int out, in, mark;
        for (out = 0; out < this.size; out++) {
            mark = out;
            for (in = out + 1; in < this.size; in++) {
                if (this.arr[in].getAge() < (this.arr[mark].getAge())) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }
    // Сортировка вставкой ---------------------------------------------------------------------------------------

    public void sortInsertPersonByName() {
        int in, out;
        for (out = 1; out < this.size; out++) {
            Person temp = this.arr[out];
            in = out;
            while (in > 0 && this.arr[in - 1].getName().compareTo(temp.getName()) > 0) {
                this.arr[in] = this.arr[in - 1];
                --in;
            }
            this.arr[in] = temp;
        }
    }

    public void sortInsertPersonByAge() {
        int in, out;
        for (out = 1; out < this.size; out++) {
            Person temp = this.arr[out];
            in = out;
            while (in > 0 && this.arr[in - 1].getAge() > (temp.getAge())) {
                this.arr[in] = this.arr[in - 1];
                --in;
            }
            this.arr[in] = temp;
        }
    }

}
