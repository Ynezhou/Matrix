# Matrix

## git代码管理相关指令

一般流程：
```
git init                  //创建新文件夹，打开，然后执行 git init,以创建新的 git 仓库。

                          //克隆仓库
git clone /path/to/repository
                          //创建一个本地仓库的克隆版本
git clone username@host:/path/to/repository
                          //远端服务器上的仓库

                          //工作流
                          //工作目录->add 暂存区（Index）-> commit to HEAD -> 远端仓库
git add <filename>
git add *
git commit -m "代码提交信息"(master)
git push origin master

git remote add origin <server>
                          //没有克隆现有仓库，并欲将你的仓库连接到某个远程服务器

                          //分支
git checkout -b branchA   //创建一个分支，并切换过去
git checkout master       //切换回主分支
git branch -d feature_x   //把新建的分支删掉
git push origin <branch>  //将分支推送到远端仓库

                          //更新与合并
git pull                  //更新你的本地仓库, 从远程数据库拉取代码
git diff <source_branch> <target_branch>
                          //合并改动之前，你可以使用如下命令预览差异
git merge <branch>        //合并其他分支到你的当前分支
git add <filename>        //标记为合并成功

                          //修改完毕
git status                //查看修改状态

github指南参考：http://www.runoob.com/manual/git-guide/
```
