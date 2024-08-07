import { Topic } from './topic';
import { User } from './user';

export class Post {
  id: number;
  content: string;
  postedIn: Topic | null;
  postPostedBy: User | null;
}
