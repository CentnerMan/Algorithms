package ru.lebedev.se.lesson2.sortint;

class ArrayInt {
    int[] arr;
    int size;

    public ArrayInt(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i]);
        }
    }

    // Поиск ------------------------------------------------------------------------------------------------------

    public boolean find(int search) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == search) break;
        }
        if (i == this.size)
            return false;
        else
            return true;
    }

    // Удаление ---------------------------------------------------------------------------------------------------

    public void delete(int search) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == search) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    // Вставка ----------------------------------------------------------------------------------------------------

    public void insert(int number) {
        this.arr[this.size] = number;
        this.size++;
    }

    // Меняем элементы местами ------------------------------------------------------------------------------------

    private void change(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    // Сортировка пузырьком ---------------------------------------------------------------------------------------

    public void sortBubbleInt() {
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (this.arr[in] > (this.arr[in + 1])) {
                    change(in, in + 1);
                }
            }
        }
    }

    // Сортировка выбором -----------------------------------------------------------------------------------------


    public void sortSelectInt() {
        int out, in, marker;
        for (out = 0; out < this.size; out++) {
            marker = out;
            for (in = out + 1; in < this.size; in++) {
                if (this.arr[in] < (this.arr[marker])) {
                    marker = in;
                }
            }
            change(out, marker);
        }
    }
    // Сортировка вставкой ---------------------------------------------------------------------------------------

    public void sortInsertObjectInt() {
        int in, out;
        for (out = 1; out < this.size; out++) {
            int temp = this.arr[out];
            in = out;
            while (in > 0 && this.arr[in - 1] > temp) {
                this.arr[in] = this.arr[in - 1];
                --in;
            }
            this.arr[in] = temp;
        }
    }
}
