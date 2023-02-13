# k8s-practice-with-database

## 쿠버네티스 실습 명세

- 데이터베이스가 쿠버네티스 안에 떠있다. (띄우세요. 단 껏다켜지면 날아가도 됨)
- 해당 데이터베이스에 패스워드를 시크릿으로 받아서
- 스프링 MVC 가 데이터를 넣고 빼고 하는 것을 짜오세요.
- 어플리케이션과 데이터베이스는 서로 다른 pod 에 있어야한다.
- (만약에 어렵다. docker-compose 라도 짜오세요)

## 배포 방법

### 1. Git clone

```bash
git clone https://github.com/mungmnb777/k8s-practice-with-database.git
```

### 2. Change Directory

```bash
cd ./k8s-practice-with-database/k8s-example-with-database
```

### 3. Create Kind Cluster

```bash
kind create cluster --config ./config.yaml
```

### 4. Create ConfigMap & Secret

```bash
kubectl apply -f ./db-config.yaml
```

```bash
kubectl apply -f ./db-secret.yaml
```

### 5. Set Service

```bash
kubectl apply -f ./k8s-mariadb-clusterip.yaml
```

```bash
kubectl apply -f ./k8s-server-nodeport.yaml
```

### 6. Run Database Deployment

```bash
kubectl apply -f ./mariadb-deployment.yaml
```

### 7. Run Application Server

```bash
kubectl apply -f ./server.yaml
```