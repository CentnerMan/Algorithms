package ru.lebedev.se.lesson6.homework;

public class TreeInt {
    private NodeTwo root;

    public NodeTwo find(int key) {
        NodeTwo current = root;
        while (current.number != key) {
            if (key < current.number) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int num) {
        NodeTwo node = new NodeTwo();
        node.number = num;
        if (root == null) {
            root = node;
        } else {
            NodeTwo current = root;
            NodeTwo parent;
            while (true) {
                parent = current;
                if (num < current.number) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int num) {
        NodeTwo current = root;
        NodeTwo parent = root;
        boolean isLeftChild = true;

        while (current.number != num) {
            parent = current;
            if (num < current.number) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        // Если узел не имеет потомков

        if (current.leftChild == null && current.rightChild == null) {
            if (current == null) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // Если нет правого потомка
        else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        // Если нет левого потомка
        else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            NodeTwo successor = getSuccesor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public NodeTwo getSuccesor(NodeTwo node) {
        NodeTwo successorParent = node;
        NodeTwo successor = node;
        NodeTwo current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("Preorder traversal");
                preOrder(root);
                break;
        }
    }

    private void preOrder(NodeTwo rootNode) {
        if (rootNode != null) {
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(NodeTwo rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void inOrder(NodeTwo rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public void displayTree() {
        StackTwo stackTwo = new StackTwo(100);
        stackTwo.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            StackTwo localStack = new StackTwo(100);
            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(' ');
            }
            while (!stackTwo.isEmpty()) {
                NodeTwo temp = stackTwo.pop();
                if (temp != null) {
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
//                    localStack.push(null);
                }
                for (int j = 0; j < (nBlanks * 2 - 2); j++)
                    System.out.print(' ');
            }
            System.out.println(' ');
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stackTwo.push(localStack.pop());
            }
            System.out.println("......................................................");
        }
    }

    public NodeTwo getRoot() {
        return root;
    }

    //-----------------------------------------
    boolean isBalanced(NodeTwo rootNode) {
        if (longestPath(rootNode) - shortestPath(rootNode) > 1)
            return false;
        else
            return true;
    }


    int longestPath(NodeTwo rootNode) {
        if (rootNode == null) {
            return 0;
        } else {
            int leftPathLength = longestPath(rootNode.leftChild);
            int rightPathLength = longestPath(rootNode.rightChild);
            if (leftPathLength >= rightPathLength)
                return leftPathLength + 1;
            else
                return rightPathLength + 1;
        }
    }

    int shortestPath(NodeTwo rootNode) {
        if (rootNode == null) {
            return 0;
        } else {
            int leftPathLength = shortestPath(rootNode.leftChild);
            int rightPathLength = shortestPath(rootNode.rightChild);
            if (leftPathLength <= rightPathLength)
                return leftPathLength + 1;
            else
                return rightPathLength + 1;
        }
    }

}
