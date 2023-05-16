import { Topic } from "./topic";
import { User } from "./user";

export class Theme {
    id: number;
    themeName: string;
    image: string;
    description: string;
    themePostedBy: User | null;
    topics: Topic[] ;
    createdAt: Date | null;
    // createdAt: Date;
    // updatedAt: Date;
}
