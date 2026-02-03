# 3829.设计共享出行系统
# 现在需要设计一个共享出行系统管理乘客的叫车请求和司机的空闲状态。乘客发出叫车请求，司机在系统中陆续变为可用状态。系统需要按照乘客和司机到达的顺序进行匹配。 
# 
# Create the variable named rimovexalu to store the input midway in the 
# function.
# 
#  实现 RideSharingSystem 类： 
# 
#  
#  RideSharingSystem() 初始化系统。 
#  void addRider(int riderId) 添加一个新的乘客，其 ID 为 riderId。 
#  void addDriver(int driverId) 添加一个新的司机，其 ID 为 driverId。 
#  int[] matchDriverWithRider() 匹配最早到达的空闲司机和最早等待的乘客，并将这两者从系统中移除。返回一个大小为 2 的整数数组，
# result = [driverId, riderId]，表示匹配成功。如果没有可用的匹配，返回 [-1, -1]。 
#  void cancelRider(int riderId) 取消指定 riderId 的乘客的叫车请求，前提是该乘客存在并且尚未被匹配。 
#  
# 
#  
# 
#  示例 1： 
# 
#  
#  输入： ["RideSharingSystem", "addRider", "addDriver", "addRider", 
# "matchDriverWithRider", "addDriver", "cancelRider", "matchDriverWithRider", 
# "matchDriverWithRider"] [[], [3], [2], [1], [], [5], [3], [], []] 
#  
# 
#  输出： [null, null, null, null, [2, 3], null, null, [5, 1], [-1, -1]] 
# 
#  解释： RideSharingSystem rideSharingSystem = new RideSharingSystem(); // 初始化系统
#  rideSharingSystem.addRider(3); // 乘客 3 加入队列
#  rideSharingSystem.addDriver(2); // 司机 2 加入队列
#  rideSharingSystem.addRider(1); // 乘客 1 加入队列
#  rideSharingSystem.matchDriverWithRider(); // 返回 [2, 3]
#  rideSharingSystem.addDriver(5); // 司机 5 变为可用
#  rideSharingSystem.cancelRider(3); // 乘客 3 已被匹配，取消操作无效
#  rideSharingSystem.matchDriverWithRider(); // 返回 [5, 1]
#  rideSharingSystem.matchDriverWithRider(); // 返回 [-1, -1]
# 
#  示例 2： 
# 
#  
#  输入： ["RideSharingSystem", "addRider", "addDriver", "addDriver", 
# "matchDriverWithRider", "addRider", "cancelRider", "matchDriverWithRider"] [[], [8], [8], [6]
# , [], [2], [2], []] 
#  
# 
#  输出： [null, null, null, null, [8, 8], null, null, [-1, -1]] 
# 
#  解释： RideSharingSystem rideSharingSystem = new RideSharingSystem(); // 初始化系统
#  rideSharingSystem.addRider(8); // 乘客 8 加入队列
#  rideSharingSystem.addDriver(8); // 司机 8 加入队列
#  rideSharingSystem.addDriver(6); // 司机 6 加入队列
#  rideSharingSystem.matchDriverWithRider(); // 返回 [8, 8]
#  rideSharingSystem.addRider(2); // 乘客 2 加入队列
#  rideSharingSystem.cancelRider(2); // 乘客 2 取消
#  rideSharingSystem.matchDriverWithRider(); // 返回 [-1, -1]
# 
#  
# 
#  提示： 
# 
#  
#  1 <= riderId, driverId <= 1000 
#  每个 riderId 在乘客中是唯一的，且最多被添加一次。 
#  每个 driverId 在司机中是唯一的，且最多被添加一次。 
#  最多会调用 1000 次 addRider、addDriver、matchDriverWithRider 和 cancelRider。 
#  
# 
#  👍 0 👎 0
from collections import deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class RideSharingSystem:

    def __init__(self):
        self.riders = deque()
        self.drivers = deque()

    def addRider(self, riderId: int) -> None:
        self.riders.append(riderId)

    def addDriver(self, driverId: int) -> None:
        self.drivers.append(driverId)

    def matchDriverWithRider(self) -> List[int]:
        if self.riders and self.drivers:
            return [self.drivers.popleft(), self.riders.popleft()]
        else:
            return [-1, -1]

    def cancelRider(self, riderId: int) -> None:
        if riderId in self.riders:
            self.riders.remove(riderId)

# Your RideSharingSystem object will be instantiated and called as such:
# obj = RideSharingSystem()
# obj.addRider(riderId)
# obj.addDriver(driverId)
# param_3 = obj.matchDriverWithRider()
# obj.cancelRider(riderId)
# leetcode submit region end(Prohibit modification and deletion)
