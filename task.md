

```
保龄球是以局(line)为单位，一局分为10轮(frame)，每轮有两次投球(throw)机会。一局游戏得分为10轮分数(score)之和。

在一轮中：
1. 两次投球后未能击倒全部10个球瓶(pin)，则本轮得分为击倒的球瓶数目。
2. 全中(strike): 就不能再投第二次，本轮得分为10加上后两次投球击倒的球瓶数。
3. 补中(spare): 本轮得分为10加上后续一次投球击倒的球瓶数。

唯有第10轮不同，第一次投球如果投得全中，仍要继续投完最后两个球；如果是补中，就要继续投完最后一球，结束全局。
```
given when then
1. given 10轮中每轮击中0pin，共投20次， when 计算得分，then score 为 0
2. given 10轮中每次击中1pin，共投20次， when 计算得分，then score 为 20
3. given 首轮为补中，其余轮每轮每次击中1pin,共投20次， when 计算得分，then score 为 11+9*2=29
3. given 首轮为全中，其余轮每轮每次击中1pin,共投20次， when 计算得分，then score 为 12+9*2=30
4. given 10轮均为补中，10轮后的一次投球击中5，共投21次，when 计算得分，then score为195
5. given 10轮均为全中，10轮后的2次投球均击中10，共投22次，when 计算得分，then score为300