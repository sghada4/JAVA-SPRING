import { Theme } from './theme';
import { User } from './user';

export class Topic {
  id: number;
  topicName: string;
  topicPostedBy: User | null;
  theme: Theme | null;
  // createdAt: Date;
  // updatedAt: Date;
}
