class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


root = TreeNode(1)
root.left = TreeNode(2)
root.right =  TreeNode(3)

root.parent = TreeNode(23)

print((root.val, root.left.val, root.right.val, root.parent.val))
