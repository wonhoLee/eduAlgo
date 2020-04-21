# eduAlgo
알고리즘 연습용
--강의들을것 : https://www.youtube.com/watch?v=qQ5iLNjpxSk&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz

## Sorting Algorithm
- https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Algorithm#%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%A5%BC-%EC%9C%84%ED%95%9C-tip

### Comparisons Sorting Algorithm(비교 방식 알고리즘)
- Bubble Sort
  - 가장 큰값을 배열의 맨끝에다 이동, 원소 개수 만큼 두번 반복
- Selection Sort
  - 비교하고 있는 값의 index를 저장, 최종적으로 한번만 교체, 여러번 비교는 마찬가지
- Insertion Srot
  - i 원소, i-1원소 부터 0번째 원소 까지 비교 i원소 보다 클경우 위치교체, 작을경우 다음순서의 원소와 비교
- Meger Srot
  - Divide and conquer
- Heap Sort
  - 데이터들을 Heap 에 넣었다가 꺼내며 sorting
  - 배열을 heap으로 만들어주는 과정을 거쳐 꺼내면서 sorting?
- Quick Sort
  - Divide and Conquer 전략 -> Divide과정에서 pivot 개념사용
### non-Comparisons Sorting Algorithm
- Counting Sort
- Radix Sort

# Structure
## 그래프
### 그래프 탐색
- https://www.youtube.com/watch?v=_hxFgg7TLZQ&t=574s
- https://blog.naver.com/ndb796/221230944971
- https://www.youtube.com/watch?v=66ZKz-FktXo&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=16
- 깊이 우선 탐색(Depth First Search : DFS)
  - Stack or 재귀함수
  - PostOrder // PreOrder // Inorder
  - 미로찾기 
- 너비 우선 탐색(Breadth First Search : BFS)
  - Queue
  - Left -> Right, Top -> Bottom
  - 최단경로, 미로찾기 알고리즘

## Tree
### 3가지 순회방법
- https://www.youtube.com/watch?v=QN1rZYX6QaA
- inorder : left, root, right
- Preorder : root, left, right
- postorder : left, right, root