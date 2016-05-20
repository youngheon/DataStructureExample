__author__ = 'Heon'

#reference onestep.tistory.com/42

#-*-coding:utf-8-*-

class Tree:
    def __init__(self,data, left_child=None, right_child=None):
        self.data = data
        self.left_child = left_child
        self.right_child = right_child


#트리를 구성하려면 자식노드를 먼저 생성하고 부모 노드에 연결
left_child = Tree(3)
right_child = Tree(4)
parent = Tree(1,left_child,right_child)

# 더 간결하게 코딩하면
parent2 = Tree(1,Tree(3),Tree(4))

def init_tree():
    # 리프 노드 생성
    leaf = []
    for i in range(6):
        leaf.append(Tree(i+1))

    # 서브 트리 생성
    left_subtree = Tree(9,Tree(7,leaf[0],leaf[1]),Tree(8,leaf[2],leaf[3]))
    right_subtree = Tree(10,leaf[4],leaf[5])

    root = Tree(11,left_subtree, right_subtree)


#트리 순회
#전위 순회(Preorder Traverse) : 뿌리를 먼저 방문
def preorder_traverse(tree):
    if tree == None: return
    print tree.data,
    preorder_traverse(tree.left_child)
    preorder_traverse(tree.right_child_child)

#중위 순회(Inorder Traverse) : 뿌리의 중간을 먼저 방문
def inorder_traverse(tree):
    if tree == None:return
    inorder_traverse(tree.left_child)
    print tree.data,
    inorder_traverse(tree.right_child)

#후위 순회(Postorder Traverse) : 뿌리를 나중에 방문
def postorder_traverse(tree):
    if tree == None: return
    postorder_traverse(tree.left_child)
    postorder_traverse(tree.right_child)
    print tree.data,

#각각 print tree.data 에 따라 전위,중위,후위 순회가 된다.
# 재귀 함수 종료 조건이 꼭 있어야 한다.

# 레벨 순회는 큐를 이용하여 구현
# 먼저 부모를 방문하고 자식은 큐에 넣는다.
# 큐에서 노드를 하나 꺼내 방문하고 그 노드가 자식을 가지고 있으면 큐에 넣는다.
levelq = []
def levelorder_traverse(tree):
    global levelq
    levelq.append(tree)
    while len(levelq)!=0:
        #방문
        visit_node = levelq.pop(0)
        print visit_node.data,
        #w자식 넣는다.
        if visit_node.left_child!=None:
            levelq.append(visit_node.left_child)
        if visit_node.right_child!=None:
            levelq.append(visit_node.right_child)


##Test Tree

root = None
def init_tree():
    global root
    #create leaf node
    leaf = []
    for i in range(6):
        leaf.append(Tree(i+1))
    #서브 트리 생성
    left_subtree = Tree(9,Tree(7,leaf[0],leaf[1]),Tree(8,leaf[2],leaf[3]))
    right_subtree = Tree(10,leaf[4],left[5])

    #루트 생성
    root = Tree(11,left_subtree,right_subtree)

def Main():
    init_tree()
    print "<Preorder Traverse>"
    preorder_traverse(root)

    print "<Inorder Traverse>"
    inorder_traverse(root)

    print "<Postorder Traverse>"
    postorder_traverse(root)
    print()

    print "<LevelOrder Traverse>"
    levelorder_traverse(root)
    print()

Main()
