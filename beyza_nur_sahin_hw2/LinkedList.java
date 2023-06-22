/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beyza_nur_sahin_hw2;

/**
 *
 * @author Beyza
 */
public class LinkedList implements HW2Interface {

    DoubleLinkNode head;
    DoubleLinkNode tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void Insert(int newElement, int pos) { //throws Exception {
        // elemen ekleme, eğer position yoksa hata fırlatsın.
        DoubleLinkNode yenieleman = new DoubleLinkNode(newElement);
        DoubleLinkNode isaretci2 = new DoubleLinkNode(0);
        isaretci2 = head;
        DoubleLinkNode isaretci1 = new DoubleLinkNode(0);
        isaretci1 = null;
        try {
            if (head == null) {
                // liste boş
                head = yenieleman;
                tail = yenieleman;
            } else if (pos == 0) { // basa ekleme
                DoubleLinkNode n = new DoubleLinkNode(newElement);
                n.right = head;
                if (head != null) {
                    head.left = n;
                }
                head = n;
            } else {
                for (int i = 0; i < pos; i++) {
                    isaretci1 = isaretci2;
                    isaretci2 = isaretci2.right;
                }
                if (isaretci2 == null) {
                    isaretci1.right = yenieleman;
                    tail = yenieleman;
                } else {
                    yenieleman.right = isaretci2;
                    isaretci2.left = yenieleman;
                    isaretci1.right = yenieleman;
                    yenieleman.left = isaretci1;

                }
            }
        } catch (Exception ex) {
            System.out.println("ekleme hatasi goruldu " + ex.toString());
        }

    }

    @Override
    public int Delete(int pos) throws Exception {
        // istenilen pozisyondaki sayıyı silme

        DoubleLinkNode isaretci2 = head;
        DoubleLinkNode isaretci1 = null;
        try {
            if (pos == 0) {
                // bastan silme
                head = isaretci2.right;
                isaretci2.left = null;

            } else {
                for (int i = 0; i < pos; i++) {
                    isaretci1 = isaretci2;
                    isaretci2 = isaretci2.right;
                }
                if (isaretci2.right == null) {
                    // sondan sil
                    isaretci1.right = null;
                    tail = isaretci1;
                } else { //aradan sil
                    isaretci1.right = isaretci2.right;
                    isaretci1.right.left = isaretci2.left;
                }
            }
        } catch (Exception e) {
            System.out.println("silme hatasi goruldu " + e.toString());
        }

        return 0;
    }

    @Override
    public void LinkReverse() {
        DoubleLinkNode temp;
        DoubleLinkNode prev = null;
        DoubleLinkNode q = head;
        while (q != null) {
            temp = q.right;
            q.right = prev;
            prev = q;
            q = temp;
        }
        head = prev;
    }

    @Override
    public void SacuraL() {
        // before -->> [1 2 3 3 3 3 2 2 2 2 1 2 2 3 2]
        // after -->> [1 1 2 1 3 4 2 4 1 1 2 2 3 1 2 1]
        DoubleLinkNode node = head;
        LinkedList list = new LinkedList();
        int deney = 0;
        while (node != null) {

            list.Insert(node.Element, deney);
            deney++;
            node = node.right;

        }
        list.tail = head;
        int listsize = findSize(list.head);
        // list.Output();

        LinkedList resultData = new LinkedList();

        Integer previousData = list.GetNth(0);
        Integer currentData;
        int count = 0;
        int j = 0;
        for (int i = 0; i < findSize(list.head); i++) {
            currentData = list.GetNth(i);

            if (previousData.equals(currentData)) {
                count += 1;

            } else {
                resultData.Insert(previousData, j);
                resultData.Insert(count, j + 1);
                count = 1;
                j = j + 2;

            }
            previousData = currentData;
        }

        resultData.Insert(previousData, j);
        resultData.Insert(count, j + 1);

        head = resultData.head;
    }

    @Override
    public void OpacuraL() {
        // before --> [1 1 2 1 3 4 2 4 1 1 2 2 3 1 2 1]
        // after --> [1 2 3 3 3 3 2 2 2 2 1 2 2 3 2]
        DoubleLinkNode node = head;
        LinkedList list1 = new LinkedList();
        LinkedList yeniListe = new LinkedList();

        int deney = 0;
        while (node != null) {
            list1.Insert(node.Element, deney);
            deney++;
            node = node.right;
        }
        // list1.tail=head;
        boolean isNew = true;
        boolean isFinish = false;
        int number = 0;
        int count = 0;
        for (int i = 0; i < findSize(list1.head) - 1; i++) {
            if (i % 2 == 0 && isNew) {
                number = list1.GetNth(i);
                isFinish = true;
            }
            if (isFinish) {
                if (count != list1.GetNth(i + 1)) {
                    count++;
                    yeniListe.Insert(number, 0);
                    i--;
                    isNew = false;
                } else {
                    isNew = true;
                    count = 0;
                    isFinish = false;
                }
            }

        }
        yeniListe.LinkReverse();
        head = yeniListe.head;
        tail = yeniListe.tail;
    }

    @Override
    public void Output() {
        // listeyi yazdırır
        DoubleLinkNode isaretci = head;
        while (isaretci != null) {
            System.out.print(isaretci.Element + " ");
            isaretci = isaretci.right;
        }
        System.out.println("\n");
    }

    @Override
    public void ReverseOutput() {
        // listenin tersini yazdırır
        DoubleLinkNode node = head;
        LinkedList list = new LinkedList();
        int deney = 0;
        while (node != null) {
            list.Insert(node.Element, deney);
            deney++;
            node = node.right;
        }
        int k = findSize(list.head);
        for (int i = k - 1; i >= 0; i--) {
            System.out.print(list.GetNth(i) + " ");
        }
    }

    @Override
    public Exception LinkedListException() {
        return null;
    }

    public int GetNth(int index) {
        DoubleLinkNode current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.Element;
            }
            count++;
            current = current.right;
        }

        assert (false);
        return 0;
    }

    static int findSize(DoubleLinkNode node) {
        int res = 0;
        while (node != null) {
            // System.out.println(node.Element);
            res++;
            node = node.right;
        }

        return res;
    }
    @Override
	public String toString() {
		String result= "";
		int size = findSize(head);
		for(int i=0; i<size; i++) {
			result+=head.Element + " ";
			head=head.right;
		}	
		System.out.print("\n");
		return result;
		
	}

}
