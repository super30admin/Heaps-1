//Max Heap

class Heap{
    constructor(){
        this.data = [];
    }

    getParentIndex(i){
        return Math.floor((i-1)/2);
    }

    getLeftChild(i){
        return i * 2 + 1
    }

    getRightChild(i){
        return i * 2 + 2;
    }

    swap(i1, i2){
        const temp = this.data[i1];
        this.data[i1] = thi.data[i2];
        this.data[i2] = temp;
    }

    push(key){
        this.data[this.data.length] = key;
        this.heapifyUp();
    }

    heapifyUp(){
        this.currentIndex = this.data.length - 1;

        while(this.data[this.currentIndex] > this.data[this.getParentIndex(this.currentIndex)]){
            this.swap(currentIndex, this.getParentIndex(currentIndex))
            this.currentIndex = this.getParentIndex(this.currentIndex)
        }
    }

    poll(){
        const maxValue = this.data[0];
        this.data[0] = this.data[this.data.length - 1];
        this.data.length--;
        this.heapifyDown();

        return maxValue;
    }

    heapifyDown(){
        let currentIndex = 0;
        while(this.data[this.getLeftChild(currentIndex)] != null){
            let biggestChildIndex = this.getLeftChild(currentIndex);

            if(this.data[this.getRightChild(currentIndex)] && this.data[this.getRightChild(currentIndex)] > this.data[this.getLeftChild(currentIndex)]){
                biggestChildIndex = this.getRightChild(currentIndex);
            }

            if(this.data[currentIndex] < this.data[biggestChildIndex]){
                this.swap(currentIndex, biggestChildIndex);
                currentIndex = biggestChildIndex;
            }
            else {
                return;
            }
        }
    }
}

const heap = new Heap();
