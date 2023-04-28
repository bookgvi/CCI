package LinkedList;

import org.junit.Test;

public class RemoveNodesFromLinkedListTest extends AbstractAssertForListNode {

    @Test
    public void removeNodes_test1() {
        ListNode head = ListNode.getInstance().from(new int[]{5, 2, 13, 3, 8});
        ListNode ans = ListNode.getInstance().from(new int[]{13, 8});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeNodes_test2() {
        ListNode head = ListNode.getInstance().from(new int[]{1,1,1,1});
        ListNode ans = ListNode.getInstance().from(new int[]{1,1,1,1});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeNodes_test3() {
        ListNode head = ListNode.getInstance().from(new int[]{1});
        ListNode ans = ListNode.getInstance().from(new int[]{1});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeNodes_test4() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5});
        ListNode ans = ListNode.getInstance().from(new int[]{5});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeNodes_test5() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,4,5,5,5});
        ListNode ans = ListNode.getInstance().from(new int[]{5,5,5});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeNodes_test6() {
        ListNode head = ListNode.getInstance().from(new int[]{1,2,3,3,3,1,1,1,4,5,5,5});
        ListNode ans = ListNode.getInstance().from(new int[]{5,5,5});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeNodes_test7() {
        ListNode head = ListNode.getInstance().from(new int[]{333,95,826,478,549,501,623,801,173,221,284,124,223,956,649,610,328,169,675,347,811,959,773,244,500,9,752,962,105,374,996,573,946,848,917,889,737,799,356,905,585,241,328,850,672,717,139,166,305,164,92,297,510,449,186,453,262,134,789,13,952,461,472,576,70,841,873,882,494,408,281,82,177,779,830,110,706,715,422,265,450,715,972,878,851,38,620,669,406,213,584,973,583,966,604,384,239,186,10,585,824,293,597,161,667,274,880,518,96,591,233,758,363,881,182,642,280,912,420,510,817,607,361,432,509,750,720,755,379,854,932,614,864,807,890,416,871,591,670,376,709,418,402,226,244,910,840,411,92,710,825,700,75,137,351,854,974,224,450,875,849,219,326,199,706,154,23,248,219,467,403,1,777,582,830,666,84,797,798,600,841,469,605,12,205,391,877,622,287,13,931,959,553,506,192,271,501,816,952,889,162,390,973,954,342,279,1000,145,3,168,84,469,304,372,7,276,587,459,441,890,852,432,802,598,48,157,388,979,991,749,773,153,776,731,102,233,252,705,386,79,283,291,399,197,513,321,241,112,159,470,336,341,455,818,579,889,360,236,969,613,131,302,155,82,136,518,434,673,590,252,976,670,738,245,844,485,622,114,416,794,520,509,60,486,132,22,569,62,715,975,437,436,180,352,691,268,147,756,1000,234,350,98,861,211,645,884,845,8,493,139,562,695,24,949,361,33,949,105,28,561,521,110,330,633,300,136,51,103,453,351,798,437,818,18,632,942,231,247,267,741,320,844,276,578,659,96,697,801,892,752,948,176,92,469,595,642,686,729,872,547,443,50,746,13,102,548,158,155,73,114,77,204,544,956,484,565,190,310,210,726,347,2,665,800,749,751,600,580,942,966,198,886,15,607,439,725,279,345,183,104,696,699,631,562,654,79,518,77,469,806,525,487,84,707,880,21,463,696,212,877,697,538,207,832,793,906,965,666,376,745,906,962,650,861,804,113,403,992,541,37,891,756,612,378,623,414,729,737,132,962,891,526,876,93,513,633,441,583,771,616,880,713,998,209,197,923,628,265,212,621,179,234,89,509,809,553,722,796,948,552,168,210,700,986,267,884,716,362,541,516,118,423,302,99,974,155,182,220,993,797,980,719,216,384,883,283,880,230,882,142,806,218,604,299,285,949,237,319,680,278,143,697,406,464,962,415,325,99,636,577,701,205,38,154,130,232,897,188,831,467,278,492,159,368,998,572,870,794,949,939,904,15,505,996,767,562,414,65,473,841,400,18,260,410,615,902,266,732,543,746,686,804,714});
        ListNode ans = ListNode.getInstance().from(new int[]{1000,1000,998,998,996,902,804,714});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeNodes_test8() {
        ListNode head = ListNode.getInstance().from(new int[]{222,5,13,13,13,3,8,11,13});
        ListNode ans = ListNode.getInstance().from(new int[]{222,13,13,13,13});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }

    @Test
    public void removeNodes_test9() {
        ListNode head = ListNode.getInstance().from(new int[]{5,13,8,13});
        ListNode ans = ListNode.getInstance().from(new int[]{13,13});
        RemoveNodesFromLinkedList r = new RemoveNodesFromLinkedList();
        ListNode res = r.removeNodes(head);
        assertEquals(ans, res);
    }
}