class PrefixTree {
    class Node{
        Map<Character, Node> childs = new HashMap<>();
        boolean ended = false;
    }
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()){
            curr.childs.putIfAbsent(ch, new Node());
            curr = curr.childs.get(ch);
        }
        curr.ended = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.childs.containsKey(ch)){
                return false;
            }
            curr = curr.childs.get(ch);
        }
        return curr.ended == true;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch: prefix.toCharArray()){
            if(!curr.childs.containsKey(ch)){
                return false;
            }
            curr = curr.childs.get(ch);
        }
        return curr != null ;
    }
}
