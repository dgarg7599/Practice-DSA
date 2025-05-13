import java.util.*;

class T {
    int userid, taskid, p;
    boolean valid;

    T(int u, int t, int pr) {
        this.userid = u;
        this.taskid = t;
        this.p = pr;
        this.valid = true;
    }
}

class TaskManager {
    Map<Integer, T> map = new HashMap<>();
    PriorityQueue<T> pq = new PriorityQueue<>((a, b) -> {
        if (a.p == b.p) {
            return Integer.compare(b.taskid, a.taskid);
        } else {
            return Integer.compare(b.p, a.p);
        }
    });

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> lst : tasks) {
            int userid = lst.get(0);
            int taskid = lst.get(1);
            int p = lst.get(2);
            T t = new T(userid, taskid, p);
            map.put(taskid, t);
            pq.add(t);
        }
    }

    public void add(int userId, int taskId, int priority) {
        T t = new T(userId, taskId, priority);
        pq.add(t);
        map.put(taskId, t);
    }

    public void edit(int taskId, int newPriority) {
        if (!map.containsKey(taskId)) return;

        T oldTask = map.get(taskId);
        oldTask.valid = false;

        T newTask = new T(oldTask.userid, taskId, newPriority);
        pq.add(newTask);
        map.put(taskId, newTask);
    }

    public void rmv(int taskId) {
        if (!map.containsKey(taskId)) return;

        T task = map.get(taskId);
        task.valid = false;
        map.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            T found = pq.poll();
            if (found.valid) {
                map.remove(found.taskid);
                return found.userid;
            }
        }
        return -1;
    }
}