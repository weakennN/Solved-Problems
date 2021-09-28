package DataStructure.Trees;

import java.util.*;

public class Tree<E> {

    private E element;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E element, Tree<E>... children) {
        this.element = element;
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            child.parent = this;
            this.children.add(child);
        }
    }

    public void bfs() {
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();

            System.out.println(current.element);

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }
    }

    public void dfs() {
        this.doDfs(this);
    }

    private void doDfs(Tree<E> tree) {
        for (Tree<E> currentTree : tree.children) {
            this.doDfs(currentTree);
        }

        System.out.println(tree.element);
    }

    public void add(E parentElement, Tree<E> toAdd) {
        Tree<E> result = this.findDfs(parentElement);

        if (result != null) {
            result.children.add(toAdd);
            toAdd.parent = result;
        }
    }

    private Tree<E> findBfs(E parentElement) {
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();

            if (current.element.equals(parentElement)) {
                return current;
            }

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }

        return null;
    }

    public void remove(E elementToRemove) {
        Tree<E> toRemove = findBfs(elementToRemove);
        if (toRemove == null) {
            return;
        }
        if (toRemove.parent != null) {
            toRemove.parent.children.remove(toRemove);
        } else {
            toRemove.element = null;
        }

        toRemove.children.clear();
    }

    public void swap(E first, E second) {
        Tree<E> firstTree = findBfs(first);
        Tree<E> secondTree = findBfs(second);

        if (firstTree == null || secondTree == null) {
            return;
        }

        Tree<E> firstTreeParent = firstTree.parent;
        Tree<E> secondTreeParent = secondTree.parent;

        if (firstTreeParent == null) {
            swapRoot(secondTree);
            return;
        } else if (secondTreeParent == null) {
            swapRoot(firstTree);
            return;
        }

        int firstIndex = firstTreeParent.children.indexOf(firstTree);
        int secondIndex = secondTreeParent.children.indexOf(secondTree);

        firstTree.parent = secondTreeParent;
        secondTree.parent = firstTreeParent;

        firstTreeParent.children.set(firstIndex, secondTree);
        secondTreeParent.children.set(secondIndex, firstTree);
    }

    private Tree<E> findDfs(E parentElement) {
        return findDfs(parentElement, this);
    }

    private Tree<E> findDfs(E parentElement, Tree<E> current) {
        if (parentElement.equals(current.element)) {
            return current;
        }

        for (Tree<E> child : current.children) {
            Tree<E> found = this.findDfs(parentElement, child);
            if (found != null && found.element.equals(parentElement)) {
                return found;
            }
        }

        return null;
    }

    private void swapRoot(Tree<E> newRoot) {
        this.element = newRoot.element;
        this.children = newRoot.children;
    }
}
