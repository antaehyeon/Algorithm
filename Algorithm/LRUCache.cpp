#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;
template<class K, class V>
struct Item {
	K key;
	V value;
	Item *prev;
	Item *next;
	Item(string k, int v) : key(k), value(v) {
		prev = NULL;
		next = NULL;
	}
};
template<class K, class V>
class Cache {
public:
	virtual bool lookup(K key, V &val) = 0;
	virtual void put(K key, V val) = 0;
};
template<class K, class V>
class LRUCache : public Cache<K, V> {
private:
	/* Doubly Linked List: Head - The most recent, Tail - The least recent */
	Item<K, V> *head;
	Item<K, V> *tail;
	void detach(Item<K, V> *item) { //Detach item from linked list : O(1)
		item->next->prev = item->prev;
		item->prev->next = item->next;
	};
	void push_front(Item<K, V> *item) { //Add the new item at the front : O(1)
		item->next = head->next;
		head->next->prev = item;
		head->next = item;
		item->prev = head;
	};
	void pop_back() { //delete item from the tail : O(1)
		Item<K, V> *item = tail->prev;
		if (item != head) {
			tail->prev = item->prev;
			delete item;
		}
		else {
			tail->prev = head;
		}
		tail->prev->next = tail;
	};
	bool back(K & key) { //Get the item from the tail: O(1)
		if (tail->prev == head) {
			return false;
		}
		key = tail->prev->key;
		return true;
	};
	/* Hash Table */
	int MaxNumEntries;
	unordered_map<K, Item<K, V>*> CacheEntries;
public:
	LRUCache(int num) :MaxNumEntries(num) {
		//head <-> tail
		head = new Item<K, V>("0", 0);
		tail = new Item<K, V>("0", 0);
		head->next = tail;
		tail->prev = head;
	};
	~LRUCache() {
		while (head->next != tail) {
			pop_back();
		}
		delete head;
		delete tail;
	}
	bool lookup(K k, V &val) {
		/* find a matching item */
		auto it = CacheEntries.find(k);
		if (it == CacheEntries.end()) { //not found
			return false;
		}
		val = (*it).second->value; //found
								   /* update linked list */
		detach((*it).second); //detach
		push_front((*it).second); //add to the head because this is the latest
		return true;
	}
	void put(K k, V val) {
		/* find a matching item: O(1) operation */
		auto it = CacheEntries.find(k);
		if (it != CacheEntries.end()) { //found
										/* update data */
			(*it).second->value = val;
			/* update linked list */
			detach((*it).second); //detach
			push_front((*it).second); //add to the head because this is the latest
			return;
		}
		/* Add new one: O(1) operation */
		if (CacheEntries.size() != MaxNumEntries) { //Cache is NOT full
			Item<K, V> *t = new Item<K, V>(k, val);
			pair<K, Item<K, V> *> entry(k, t);
			CacheEntries.insert(entry);
			push_front(t); //Latest one
		}
		else { //Cache is full
			   /* Select Victim & delete */
			K key;
			back(key); //get the key of the oldest one
			pop_back();       //remove the oldest one
			auto rt = CacheEntries.find(key);
			if (rt != CacheEntries.end()) { //found
				CacheEntries.erase(rt); //delete
			}
			Item<K, V> *t = new Item<K, V>(k, val);
			pair<K, Item<K, V> *> entry(k, t);
			CacheEntries.insert(entry);
			push_front(t); //Latest one
		}
	}
};
