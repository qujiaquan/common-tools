git config --global user.name "quaquan"
git config --global user.email "2933503769@qq.com"
创建 git 仓库:

mkdir shuqingge2
cd shuqingge2
git init 
touch README.md
git add README.md
git commit -m "first commit"
git remote add origin https://gitee.com/quaquan/shuqingge2.git
git push -u origin "master"
已有仓库?

cd existing_git_repo
git remote add origin https://gitee.com/quaquan/shuqingge2.git
git push -u origin "master"
