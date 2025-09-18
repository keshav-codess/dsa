class TaskManager {
    private Map<Integer, int[]> taskMap; // taskId -> [userId, priority]
    private PriorityQueue<int[]> heap;   // [priority, taskId]

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        heap = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0]; // higher priority first
            return b[1] - a[1];                   // if tie, higher taskId first
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            heap.offer(new int[]{priority, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        heap.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        if (!taskMap.containsKey(taskId)) return;
        int userId = taskMap.get(taskId)[0];
        taskMap.put(taskId, new int[]{userId, newPriority});
        heap.offer(new int[]{newPriority, taskId});
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            int priority = top[0], taskId = top[1];
            if (taskMap.containsKey(taskId) && taskMap.get(taskId)[1] == priority) {
                int userId = taskMap.get(taskId)[0];
                taskMap.remove(taskId);
                return userId;
            }
        }
        return -1;
    }
}
