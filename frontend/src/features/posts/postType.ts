export type post = {
  id: string;
  menssage: string;
  quantLike: number;
  commentCount: number;
  creationTime: string;
  filePath: string | null;
  liked: boolean;
  createUser: string,
  parentId: postWithoutComment;
  comments?: postWithoutComment[];
};

export type postWithoutComment = {
  parentId: string | null;
} & Omit<post, "parentId">;

export type createpostRequest = {
  message: string;
  parentId?: string;
};

export type allPost = {
  content: post[];
  number: number;
  totalElements: number;
  totalPages: number;
  first: boolean;
  last: boolean;
  empty: boolean;
};
