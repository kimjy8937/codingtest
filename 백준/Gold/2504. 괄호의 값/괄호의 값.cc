#include <iostream>
#include <stack>
#include <string>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(nullptr);
	std::cout.tie(nullptr);

	std::string str = "";
	std::stack<std::pair<char, int>> s;
	bool bSucess = true;
	int result = 0;

	std::cin >> str;

	for (int i = 0; i < (int)str.size(); i++)
	{
		const char& c = str[i];

		if ('(' == c || '[' == c)
		{
			if (true == s.empty())
			{
				if ('(' == c)
				{
					s.push({ c, 2 });
				}
				else if ('[' == c)
				{
					s.push({ c, 3 });
				}
			}
			else
			{
				if ('(' == c)
				{
					s.push({ c, s.top().second * 2 });
				}
				else if('[' == c)
				{
					s.push({ c, s.top().second * 3 });
				}
			}
		}
		else
		{
			char prev_c;

			if (i > 0)
			{
				prev_c = str[i - 1];
			}
			else
			{
				bSucess = false;
				break;
			}

			if (true == s.empty())
			{
				bSucess = false;
				break;
			}

			if (')' == c && '(' == prev_c)
			{
				result += s.top().second;
				s.pop();
			}
			else if (']' == c && '[' == prev_c)
			{
				result += s.top().second;
				s.pop();
			}
			else
			{
				if (')' == c && '(' == s.top().first)
				{
					s.pop();
				}
				else if (']' == c && '[' == s.top().first)
				{
					s.pop();
				}
				else
				{
					bSucess = false;
					break;
				}
			}
		}
	}

	if (true == s.empty() && true == bSucess)
	{
		std::cout << result;
	}
	else
	{
		std::cout << "0";
	}

	return 0;
}