package com.zh.struct;

import java.util.LinkedList;

/**
 * 二分搜索树，也叫二分查找树
 */
public class QBST<K extends Comparable<K>, V> {
    class QNode {
        K key;
        V value;
        QNode left;
        QNode right;

        QNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        QNode(QNode node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private QNode root;
    private int count;


    public QBST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    // 向以node为根的二叉搜索树中，插入节点(key,value)
    // 返回插入新节点后的二叉搜索树的根
    private QNode insert(QNode node, K key, V value) {
        checkNotNull(key,"key is null");

        if (node == null) {
            count++;
            return new QNode(key, value);
        }

        if (key.compareTo(node.key) == 1) {
            node.right = insert(node.right, key, value);
        } else if (key.compareTo(node.key) == -1) {
            node.left = insert(node.left, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    public boolean contain(K key) {
        return contain(root, key);
    }

    // 向以node为根的二叉搜索树中，查找是否包含key的节点
    private boolean contain(QNode node, K key) {
        checkNotNull(key,"key is null");

        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 1) {
            return contain(node.right,key);
        } else if (key.compareTo(node.key) == -1) {
            return contain(node.left.key);
        } else {
            return true;
        }
    }

    public V search(K key){
        return search(root,key);
    }

    // 向以node为根的二叉搜索树中，
    private V search(QNode node,K key){
        checkNotNull(key,"key is null");

        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) == 1){
            return search(node.right,key);
        }else if(key.compareTo(node.key) == -1){
            return search(node.left,key);
        }else {
            return node.value;
        }
    }

    // 前序遍历 O(n)
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(QNode node){
        if(node != null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 中序遍历 O(n)
    public void middleOrder(){
        middleOrder(root);
    }

    private void middleOrder(QNode node){
        if(node != null){
            middleOrder(node.left);
            System.out.println(node.key);
            middleOrder(node.right);
        }
    }

    // 后序遍历 O(n)
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(QNode node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    // 层序遍历，也叫做广度优先遍历
    public void levelOrder(){
        if(root == null){
            return;
        }

        LinkedList<QNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()){
            QNode node = queue.removeLast();
            System.out.println(node.key);
            queue.addLast(node.left);
            queue.addLast(node.right);
        }
    }

    public void destroy(){
        destroy(root);
    }

    // 销毁操作就是后序遍历的一次应用
    private void destroy(QNode node){
        if(node != null){
            destroy(node.left);
            destroy(node.right);

            node = null;
            count--;
        }
    }

    public K minimum(){
        checkNotNull(root,"the tree is empty");
        QNode minNode = minimum(root);
        return minNode.key;
    }

    public K maximum(){
        checkNotNull(root,"the tree is empty");
        QNode maxNode = maximum(root);
        return maxNode.key;
    }

    // 在以node为根的二叉搜索树中，返回最小键值的节点
    private QNode minimum(QNode node){
        if(node.left == null){
            return node;
        }

        return minimum(node.left);
    }

    // 在以node为根的二叉搜索树中，返回最大键值的节点
    private QNode maximum(QNode node){
        if(node.right == null){
            return node;
        }

        return maximum(node.right);
    }

    // 删除二叉搜索树中最小的节点
    public void removeMin(){
        if(root != null){
            root = removeMin(root);
        }
    }

    // 删除掉以node为根的二分搜索树中的最小的节点
    // 返回删除节点后新的二分搜索树的根
    private QNode removeMin(QNode node){
        if(node.left == null){
            QNode rightNode = node.right;
            node = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 删除二叉搜索树中最大的节点
    public void removeMax(){
        if(root != null){
            root = removeMax(root);
        }
    }

    // 删除掉以node为根的二分搜索树中的最大的节点
    // 返回删除节点后新的二分搜索树的根
    private QNode removeMax(QNode node){
        if(node.right == null){
            QNode leftNode = node.left;
            count--;
            node = null;

            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(K key){
        root = remove(root,key);
    }

    // 删除掉以node为根的二分搜索树中键值为key的节点
    // 返回删除节点后新的二分搜索树的根
    // O(logN)
    private QNode remove(QNode node,K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) == -1){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key) == 1){
            node.right = remove(node.right,key);
            return node;
        }else {
            if(node.left == null){
                QNode rightNode = node.right;
                count--;
                node = null;

                return rightNode;
            }

            if(node.right == null){
                QNode leftNode = node.left;
                count--;
                node = null;
                return leftNode;
            }

            //下面是 node.left != null && node.right != null
            QNode s = new QNode(minimum(node.right));
            s.right = removeMin(node.right);
            s.left = node.left;

            return s;
        }
    }


    private <E> void checkNotNull(E e,String message){
        if(e == null){
            throw new IllegalArgumentException(message);
        }
    }

}


