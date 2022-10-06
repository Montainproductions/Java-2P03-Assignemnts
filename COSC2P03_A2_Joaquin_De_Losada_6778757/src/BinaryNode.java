public class BinaryNode {
    public int Depth(Drug drugNode){
        if(drugNode == null){
            return -1;
        }
        if((drugNode.left == null) && (drugNode.right == null)){
            return 0;
        }

        int d = math.max(Depth(drugNode.left), Depth(drugNode.right));
        return d+1;
    }

    public void InOrderTraverse(Drug drugNode){
        if(drugNode == null){
            return;
        }

        InOrderTraverse(drugNode.left);
        //maincode?


        InOrderTraverse(drugNode.right);
    }
}
