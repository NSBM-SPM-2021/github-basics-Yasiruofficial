# HR PORTAL 
## Check the site on [HR PORTAL](http://dev.nsbm.xyz/)

<table>
    <thead>
        <tr>
            <th>USERNAME</th>
            <th>PASSWORD</th>
            <th>ROLE</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>L1 Name</td>
            <td>L2 Name A</td>
            <td>L3 Name A</td>
        </tr>
        <tr>
            <td>HOHR2</td>
            <td>456</td>
            <td>STAFF</td>
        </tr>
        <tr>
            <td colspan=2>Default password for newly created user</td>
            <td>456</td>
        </tr>
    </tbody>
</table>


- ### Hosting/IaaS - ![Docker Automated build](https://img.shields.io/badge/Digital_Ocean-0080FF?style=flat&logo=DigitalOcean&logoColor=white) 
- ### Server - ![Nginx](https://img.shields.io/badge/nginx-%23009639.svg?style=flat&logo=nginx&logoColor=white) ![Tomcat](https://img.shields.io/badge/apache-tomcat-yellow?style=flat&logo=apache&logoColor=white)
- ### Frameworks - ![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=flat&logo=angular&logoColor=white) ![Spring](https://img.shields.io/badge/spring_boot-%236DB33F.svg?style=flat&logo=spring&logoColor=white) 
- ### Database - ![MySQL](https://img.shields.io/badge/AWS-RDS-yellow?style=flat&logo=rds&logoColor=white)
- ### Virtualization - ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=flat&logo=docker&logoColor=white)
- ### Container orchestration - ![Swarm](https://img.shields.io/badge/docker%20-swarm-blue?style=flat&logo=docker&logoColor=white)
- ### CI - ![GitHub Actions](https://img.shields.io/badge/githubactions-%232671E5.svg?style=flat&logo=githubactions&logoColor=white)
- ### Role Based Access Control - ![auth0](https://img.shields.io/badge/spring-security-green?style=flat&logo=spring&logoColor=white)  ![auth0](https://img.shields.io/badge/Auth0-JWT-yellowgreen?style=flat&logo=auth0&logoColor=white)
  - **ADMINS** can only VIEW and ADD another **ADMIN**
  - **ADMINS** can VIEW, ADD, EDIT and DELETE **STAFF** members
  - **STAFF** members can only VIEW **ADMINS and other STAFF** members




## Usage

```powershell
docker run -p 8080:80 -d yasiru1999/hr-portal:frontend
docker run -p 9001:9001 -d yasiru1999/hr-portal:backend
```
#### or

```powershell
docker service create --replicas 2 --publish published=8080,target=80 --name="frontendservice" yasiru1999/hr-portal:frontend
docker service create --replicas 2 --publish published=9001,target=9001 --name="backendservice" yasiru1999/hr-portal:backend
```

## Contributing
Pull requests are welcome.
Please make sure to update tests as appropriate.


# Related to the assingment

## Project Management 
### Tool - ZENHUB (altenative to trello)
##### Project Management Board URL -> [github-basics-Yasiruofficial - DEV](https://app.zenhub.com/workspaces/nsbm-spm-2021---dev-612ddc9995710600125b61fc/board)
### Relevent Screenshots of 1st Sprint

# Agile Board
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/boarde.PNG)
# Epic - user_login
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/epice.png)
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/epic2e.png)
# One example user story for above Epic (user_login)
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/use.png)
# User login Release
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/ulr.PNG)
# Burndown Report for Spring 1
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/bdr.PNG)

## Technical
### Relevent Screenshots of CI/CD and Unit Testing
# CI/CD
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/pipeline.PNG)
# Unit Testing framework - Jasmine | Task runner - Karma
# - In My PC ( VIDEO )
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/testpc.gif)
# - In CI
![BDR](https://github.com/NSBM-SPM-2021/github-basics-Yasiruofficial/blob/dev/Screenshots/testgit.PNG)





