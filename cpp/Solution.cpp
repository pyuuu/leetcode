#include<vector>
#include<map>
using namespace std;

void print(){

}

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
}; 

class Solution {
    public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> result;
        std::vector<int> v;
        for (int i = 0; i < nums.size(); ++i)
        {
        	printf("%d--%d...", nums[i], result[nums[i]]);
        	if(result[nums[i]]!=0)
        	{
        		v.push_back(result[nums[i]]-1);
        		v.push_back(i);
        		break;
        	}
        	result[target - nums[i]] = i + 1;
        	printf("%d,%d,%d,%d\n",nums[i], target - nums[i], i,result[target - nums[i]]);
        }
        return v;
    }

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(!l1) return l2;
        if(!l2) return l1;
        ListNode* lTemp = l1;
        while(true){
        	if(l2){
        		lTemp->val += l2->val;
        		l2 = l2->next;
        	}
        	if(lTemp->val > 9){
        		lTemp->val = lTemp->val%10;
        		if(!lTemp->next){
        			lTemp->next = new ListNode(1);
        		}
        		else{
        			lTemp->next->val ++; 
        		}
        	}
        	if(!l2 && (!lTemp->next || (lTemp->next && lTemp->next->val<10))){
        		break;
        	}
        	else{
        		if(!lTemp->next){
        			lTemp->next = new ListNode(0);
        		}
        		lTemp = lTemp->next;
        	}
        }
        return l1;
    }
};

int main(int argc, char const *argv[])
{
	// twoSum
	Solution* s = new Solution();
	// int a[4] = {2, 7, 11, 15};
	// std::vector<int> v;
	// for (int i = 0; i < 4; ++i)
	// {
	// 	v.push_back(a[i]);
	// }
	// std::vector<int> result = s->twoSum(v, 9);
	// for (std::vector<int>::iterator i = result.begin(); i != result.end(); ++i)
	// {
	// 	printf("%d", *i);
	// }
	// printf("\naaaa");

	//addTwoNumbers
	// [2,4,3]
	// [5,6,4]
	// ListNode* l1 = new ListNode(9);
	// l1->next = new ListNode(9);
	// ListNode* l2 = new ListNode(9);
	// l1 = s->addTwoNumbers(l1, l2);
	// while(l1){
	// 	printf("%d\n", l1->val);
	// 	l1 = l1->next;
	// }
	
	return 0;
}
